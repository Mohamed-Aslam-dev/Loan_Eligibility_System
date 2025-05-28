package com.loan_eligibility_system_homeloan.service_repository;

import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyRequestDTO;

public interface HomeloanApplyServiceRepository {
	
	public String applyLoan(HomeloanApplyRequestDTO newLoanApplyData);

}
