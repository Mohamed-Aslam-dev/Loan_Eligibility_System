package com.loan_eligibility_system_homeloan.beans;

import com.loan_eligibility_system_homeloan.enums.EmploymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HomeloanApplyIncomeDatas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
	private EmploymentType employmentType;
	private Double annualIncome;
	private String yearsOfExperience;

	public HomeloanApplyIncomeDatas() {

	}

	public HomeloanApplyIncomeDatas(Integer sNo, EmploymentType employmentType, Double annualIncome,
			String yearsOfExperience) {

		this.sNo = sNo;
		this.employmentType = employmentType;
		this.annualIncome = annualIncome;
		this.yearsOfExperience = yearsOfExperience;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
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
		return "HomeloanApplyIncomeDatas [sNo=" + sNo + ", employmentType=" + employmentType + ", annualIncome="
				+ annualIncome + ", yearsOfExperience=" + yearsOfExperience + "]";
	}

}
