package com.loan_eligibility_system_admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;

@Repository
public interface AdminLoanDataRepository extends JpaRepository<HomeloanApplyLoanDatas, Integer>{
	
	Optional<HomeloanApplyLoanDatas> findAllByLoanReferenceId(String loanReferenceId);
	long countByStatus(LoanStatus status);
	Optional<List<HomeloanApplyLoanDatas>> findAllByStatus(LoanStatus status);

}
