package com.loan_eligibility_system_homeloan.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.loan_eligibility_system_homeloan.beans.HomeloanApplyHomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyIncomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyPersonalDatas;
import com.loan_eligibility_system_homeloan.enums.EmploymentType;

public class HomeloanApplyDecisionService {
	
	private static Double getCibilInterestRate;
	static String message;

	public static String generateLoanReferenceId() {

		int year = LocalDate.now().getYear();
		String prefix = "HMLN";
		String random = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		return prefix + "_" + year + "_" + random;
	}

	public static int generateCibilScore() {

		Random generateRandomCibilScore = new Random();

		return generateRandomCibilScore.nextInt(350) + 500;
	}

	public static Boolean checkEligibilityForLoan(HomeloanApplyPersonalDatas personalData,
			HomeloanApplyIncomeDatas incomeData, HomeloanApplyHomeDatas homeData, HomeloanApplyLoanDatas loanData) {

		int annualIncome = 25000 * 12;
		int age = HomeloanApplyDecisionService.calculateAge(personalData.getDateOfBirth());
		int cibilScore = loanData.getCibilScore();

		if ((age >= 21 && age <= 60 && EmploymentType.SALARIED.equals(incomeData.getEmploymentType()))
				|| (age >= 21 && age <= 65 && EmploymentType.SELF_EMPLOYED.equals(incomeData.getEmploymentType()))) {
			if (incomeData.getAnnualIncome() > annualIncome) {
				if (cibilScore > 600 && cibilScore <= 850) {
					getCibilInterestRate = getInterestByCibilScore(cibilScore); // stored on interest
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

	private static void setUserMessage(String category) {
        switch (category) {
            case "age":
                message = "REJECTED: Your age does not meet the eligibility criteria for a loan.";
                break;
            case "income":
                message = "REJECTED: Your annual income must be more than ₹300,000 to be eligible.";
                break;
            case "cibil":
                message = "REJECTED: Your CIBIL score is below 600, so you are not eligible for a loan.";
                break;
            case "accepted" :
            	message = "ACCEPTED: Congratulations! Your loan has been approved. We’ll contact you shortly.";
        }
    }

	private static Double getInterestByCibilScore(int cibilScore) {

		if (cibilScore >= 600 && cibilScore < 650)
			return 12.5;
		else if (cibilScore >= 650 && cibilScore < 700)
			return 11.5;
		else if (cibilScore >= 700 && cibilScore < 750)
			return 10.5;
		else if (cibilScore >= 750 && cibilScore <= 850)
			return 8.5;
		else
			return 0.0;

	}

	private static int calculateAge(Date dob) {
		if (dob == null)
			return 0;

		// Convert java.util.Date to java.time.LocalDate
		Instant instant = dob.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate birthDate = zdt.toLocalDate();

		return Period.between(birthDate, LocalDate.now()).getYears();
	}

}
