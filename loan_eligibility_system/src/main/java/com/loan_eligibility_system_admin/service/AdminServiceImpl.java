package com.loan_eligibility_system_admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan_eligibility_system_admin.repository.AdminLoanDataRepository;
import com.loan_eligibility_system_admin.repository.UserQueryDataRepository;
import com.loan_eligibility_system_any_queries.AnyQueries;
import com.loan_eligibility_system_email_verification.EmailSenderService;
import com.loan_eligibility_system_exceptions.LoanNotFoundException;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyHomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyIncomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyPersonalDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.responseDTO.HomeloanGetApplyDetails;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminLoanDataRepository adminLoanDataRepository;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private UserQueryDataRepository userQueryDataRepository;

	public HomeloanGetApplyDetails getTheLoanDetailsByRef(String loanReferenceId) {
		HomeloanApplyLoanDatas test = adminLoanDataRepository.findAllByLoanReferenceId(loanReferenceId)
				.orElseThrow(() -> new LoanNotFoundException("Not found.."));
		HomeloanApplyPersonalDatas personal = test.getPersonalData();
		HomeloanApplyHomeDatas home = test.getHomeData();
		HomeloanApplyIncomeDatas income = test.getIncomeData();
		return new HomeloanGetApplyDetails(personal.getFullName(), personal.getMobileNumber(), home.getLandOwnerName(),
				test.getCibilScore(), test.getBankName(), test.getLoanReferenceId(), test.getStatus());
	}

	public Long conutPendingLoans() {

		return adminLoanDataRepository.countByStatus(LoanStatus.PENDING);
	}

	public Long conutApprovedLoans() {

		return adminLoanDataRepository.countByStatus(LoanStatus.APPROVED);
	}

	public Long conutRejectedLoans() {

		return adminLoanDataRepository.countByStatus(LoanStatus.REJECTED);
	}

	public List<HomeloanApplyLoanDatas> getPendingLoanDatas(LoanStatus status) {

		return adminLoanDataRepository.findAllByStatus(status)
				.orElseThrow(() -> new LoanNotFoundException("Not Founded...."));
	}
	
	public void loanApprovedRequest(String loanRefID) {
	    HomeloanApplyLoanDatas loan = adminLoanDataRepository.findAllByLoanReferenceId(loanRefID)
	            .orElseThrow(() -> new LoanNotFoundException("Not found.."));
	    loan.setStatus(LoanStatus.APPROVED);
	    adminLoanDataRepository.save(loan);
	    emailSenderService.sendApprovedMessageToEmail(loan.getPersonalData().getMailId(), loanRefID, loan.getLoanAmount());
	}

	public void loanRejectRequest(String loanRefID) {
	    HomeloanApplyLoanDatas loan = adminLoanDataRepository.findAllByLoanReferenceId(loanRefID)
	            .orElseThrow(() -> new LoanNotFoundException("Not found.."));
	    loan.setStatus(LoanStatus.REJECTED);
	    adminLoanDataRepository.save(loan);
	}

	public List<AnyQueries> allQueries() {
		
		List<AnyQueries> queryList = userQueryDataRepository.findAll();
	
		return queryList;
	}

//	@Override
//	public List<Admin> getPendingLoans() {
//		List<Admin> loans = adminRepository.findByStatus("PENDING");
//		
//		if(loans.isEmpty()) {
//			throw new ResourcesNotFoundException("No pending loans found");
//		}
//		return loans;
//	}
//	
//	@Override
//	public Admin approveLoan(String loanId, AdminApprovalRequest request) {
//		Admin admin = adminRepository.findByLoanId(loanId);
//		
//		 if (admin == null) {
//		        throw new ResourcesNotFoundException("Loan ID not found: " + loanId);
//		    }
//		
//		admin.setStatus("Approved_By_Admin");
//		admin.setAdmincomment(request.getAdminComment());
//		admin.setAdminApprovedAt(LocalDateTime.now());
//		admin.setUpdatedDate(LocalDateTime.now());
//		
//		return adminRepository.save(admin);
//	}
//
//	@Override
//	public Admin rejectLoan(String loanId, AdminApprovalRequest request) {
//		Admin admin = adminRepository.findByLoanId(loanId);
//		
//		if(admin == null) {
//			throw new ResourcesNotFoundException("Loan ID not found: " + loanId);
//		}
//		
//		admin.setStatus("Rejected_By_Admin");
//		admin.setAdmincomment(request.getAdminComment());
//		admin.setAdminApprovedAt(LocalDateTime.now());
//		admin.setUpdatedDate(LocalDateTime.now());
//		return adminRepository.save(admin);
//	}
//
//	@Override
//	public Admin getLoanById(String loanId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public Map<String, Long> getStatusCounts() {
//        Map<String, Long> map = new HashMap<>();
//        map.put("PENDING", adminRepository.findByStatus("PENDING"));
//        map.put("APPROVED", adminRepository.findByStatus("APPROVED"));
//        map.put("REJECTED", adminRepository.findByStatus("REJECTED"));
//        return map;

}
