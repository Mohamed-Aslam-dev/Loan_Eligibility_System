package com.loan_eligibility_system_homeloan.service_repository;


import com.loan_eligibility_system_homeloan.beans.HomeloanApplyDocuments;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyHomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyIncomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyPersonalDatas;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyDocumentsDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyHomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyIncomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyLoanDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyPersonalDTO;
import com.loan_eligibility_system_homeloan.responseDTO.HomeloanGetApplyDetails;
import com.loan_eligibility_system_homeloan.responseDTO.LoanApplyResponseDTO;

import jakarta.servlet.http.HttpSession;

public interface HomeloanApplyServiceRepository {
	
	HomeloanApplyPersonalDatas applyPersonalData(HomeloanApplyPersonalDTO personalDTO);
	HomeloanApplyIncomeDatas applyIncomeData(HomeloanApplyIncomeDTO incomeDTO);
	HomeloanApplyHomeDatas applyHomeData(HomeloanApplyHomeDTO homeDTO);
	LoanApplyResponseDTO finalLoanSubmission(HomeloanApplyPersonalDTO personalDTO, HomeloanApplyIncomeDTO incomeDTO,
			HomeloanApplyHomeDTO homeDTO, HomeloanApplyLoanDTO loanDTO, HomeloanApplyDocumentsDTO documentsDTO);
	HomeloanApplyDocuments applyDocuments(HomeloanApplyDocumentsDTO documentsDTO, HomeloanApplyLoanDatas loanData);
	boolean processBeforeOtpVerification(HomeloanApplyPersonalDTO personalDTO, HomeloanApplyIncomeDTO incomeDTO,
			HomeloanApplyHomeDTO homeDTO, HomeloanApplyLoanDTO loanDTO, HttpSession session);
	String getRejectionReason();
	HomeloanGetApplyDetails getTheLoanDetails(Integer id);
	HomeloanGetApplyDetails getTheLoanDetailsByRef(String loanReferenceId);

}
