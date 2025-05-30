package com.loan_eligibility_system_homeloan.requestDTO;

import com.loan_eligibility_system_homeloan.enums.EmploymentType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class HomeloanApplyIncomeDTO {

	@NotNull(message = "Please Select Your Employment Type")
	@Enumerated(EnumType.STRING)
	private EmploymentType employmentType;

	@NotNull(message = "Please Enter Your Annual Income")
	@Positive(message = "Annual Income must be positive")
	private Double annualIncome;

	@Pattern(regexp = "\\d{1,2}", message = "Enter years of experience as a number (e.g., 5, 10)")
	private String yearsOfExperience;

	public HomeloanApplyIncomeDTO() {

	}

	public HomeloanApplyIncomeDTO(
			@NotNull(message = "Please Select Your Employment Type") EmploymentType employmentType,
			@NotNull(message = "Please Enter Your Annual Income") @Positive(message = "Annual Income must be positive") Double annualIncome,
			@Pattern(regexp = "\\d{1,2}", message = "Enter years of experience as a number (e.g., 5, 10)") String yearsOfExperience) {
		this.employmentType = employmentType;
		this.annualIncome = annualIncome;
		this.yearsOfExperience = yearsOfExperience;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public String toString() {
		return "HomeloanApplyIncomeDTO [employmentType=" + employmentType + ", annualIncome=" + annualIncome
				+ ", yearsOfExperience=" + yearsOfExperience + "]";
	}

}
