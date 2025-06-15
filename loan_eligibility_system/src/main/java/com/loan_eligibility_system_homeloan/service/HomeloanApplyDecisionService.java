package com.loan_eligibility_system_homeloan.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.loan_eligibility_system_homeloan.enums.EmploymentType;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyHomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyIncomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyLoanDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyPersonalDTO;

@Service
public class HomeloanApplyDecisionService {
	
	private Double getCibilInterestRate;
    private String message;

    public String generateLoanReferenceId() {
        int year = LocalDate.now().getYear();
        String prefix = "HMLN";
        String random = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return prefix + "_" + year + "_" + random;
    }

    public int generateCibilScore() {
        Random generateRandomCibilScore = new Random();
        return generateRandomCibilScore.nextInt(350) + 500;
    }

    public Boolean checkEligibilityForLoan(HomeloanApplyPersonalDTO personalDTO, HomeloanApplyIncomeDTO incomeDTO,
                                          HomeloanApplyHomeDTO homeDTO, HomeloanApplyLoanDTO loanDTO) {
        int annualIncome = 25000 * 12;
        int age = calculateAge(personalDTO.getDateOfBirth());
        int cibilScore = loanDTO.getCibilScore();

        if ((age >= 21 && age <= 60 && EmploymentType.SALARIED.equals(incomeDTO.getEmploymentType()))
                || (age >= 21 && age <= 65 && EmploymentType.SELF_EMPLOYED.equals(incomeDTO.getEmploymentType()))) {
            if (incomeDTO.getAnnualIncome() > annualIncome) {
                if (cibilScore > 600 && cibilScore <= 850) {
                    getCibilInterestRate = getInterestByCibilScore(cibilScore);
                    setUserMessage("accepted");
                    return true;
                } else {
                    setUserMessage("cibil");
                    return false;
                }
            } else {
                setUserMessage("income");
                return false;
            }
        } else {
            setUserMessage("age");
            return false;
        }
    }

    private void setUserMessage(String category) {
        switch (category) {
            case "age":
                setMessage("REJECTED: Your age does not meet the eligibility criteria for a loan.");
                break;
            case "income":
                setMessage("REJECTED: Your annual income must be more than ₹300,000 to be eligible.");
                break;
            case "cibil":
                setMessage("REJECTED: Your CIBIL score is below 600, so you are not eligible for a loan.");
                break;
            case "accepted":
                setMessage("ACCEPTED: Congratulations! Your loan has been approved. We’ll contact you shortly.");
        }
    }

    private Double getInterestByCibilScore(int cibilScore) {
        if (cibilScore >= 600 && cibilScore < 650) return 12.5;
        else if (cibilScore >= 650 && cibilScore < 700) return 11.5;
        else if (cibilScore >= 700 && cibilScore < 750) return 10.5;
        else if (cibilScore >= 750 && cibilScore <= 850) return 8.5;
        else return 0.0;
    }

    private int calculateAge(LocalDate dob) {
        if (dob == null) return 0;
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public Double getGetCibilInterestRate() {
        return getCibilInterestRate;
    }

    public void setGetCibilInterestRate(Double getCibilInterestRate) {
        this.getCibilInterestRate = getCibilInterestRate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
