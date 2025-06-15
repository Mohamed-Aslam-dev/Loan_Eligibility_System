package com.loan_eligibility_system_admin.service;

import java.util.List;

import com.loan_eligibility_system_any_queries.AnyQueries;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.responseDTO.HomeloanGetApplyDetails;



public interface AdminService {

	HomeloanGetApplyDetails getTheLoanDetailsByRef(String loanReferenceId);
	Long conutPendingLoans();
	Long conutApprovedLoans();
	Long conutRejectedLoans();
	List<HomeloanApplyLoanDatas> getPendingLoanDatas(LoanStatus status);
	void loanApprovedRequest(String loanRefID);
	void loanRejectRequest(String loanRefID);
	List<AnyQueries> allQueries(); 
//	List<Admin> getPendingLoans();
//	Admin approveLoan(String loanId, AdminApprovalRequest request);
//	Admin rejectLoan(String loanId, AdminApprovalRequest request);
//	Admin getLoanById(String loanId);
}
