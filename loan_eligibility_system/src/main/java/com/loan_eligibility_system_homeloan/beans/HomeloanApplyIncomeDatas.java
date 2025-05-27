package com.loan_eligibility_system_homeloan.beans;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class HomeloanApplyIncomeDatas {
	
	enum EmploymentType{
		SALARIED,SELF_EMPLOYED,BUSINESS
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer sNo;
	EmploymentType employmentType;
	Double annualIncome;
	String yearsOfExperience;
	
}
