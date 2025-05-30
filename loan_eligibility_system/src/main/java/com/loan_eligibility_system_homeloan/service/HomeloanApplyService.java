package com.loan_eligibility_system_homeloan.service;


import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.loan_eligibility_system_exceptions.LoanNotFoundException;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyHomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyIncomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyPersonalDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.repository.HomeloanApplyRepository;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyHomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyIncomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyLoanDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyPersonalDTO;
import com.loan_eligibility_system_homeloan.responseDTO.HomeloanGetApplyDetails;
import com.loan_eligibility_system_homeloan.responseDTO.LoanApplyResponseDTO;
import com.loan_eligibility_system_homeloan.service_repository.HomeloanApplyServiceRepository;

@Service
public class HomeloanApplyService implements HomeloanApplyServiceRepository {

	private HomeloanApplyRepository homeloanApplyRepository;

	public HomeloanApplyService(HomeloanApplyRepository homeloanApplyRepository) {

		this.homeloanApplyRepository = homeloanApplyRepository;

	}

	private HomeloanApplyPersonalDatas newHomeLoanPersonalData;
	private HomeloanApplyIncomeDatas newHomeLoanIncomeData;
	private HomeloanApplyHomeDatas newHomeLoanHomeData;
	private HomeloanApplyLoanDatas newHomeLoanLoanData;

	public String applyPersonalData(HomeloanApplyPersonalDTO newLoanApplyPersonalData) {

		newHomeLoanPersonalData = new HomeloanApplyPersonalDatas();
//		BeanUtils.copyProperties(newLoanApplyData, newHomeLoanPersonalData);
		newHomeLoanPersonalData.setFullName(newLoanApplyPersonalData.getFullName());
		newHomeLoanPersonalData.setMailId(newLoanApplyPersonalData.getMailId());
		newHomeLoanPersonalData.setGender(newLoanApplyPersonalData.getGender());
		newHomeLoanPersonalData.setAadharNumber(newLoanApplyPersonalData.getAadharNumber());
		newHomeLoanPersonalData.setDateOfBirth(newLoanApplyPersonalData.getDateOfBirth());
		newHomeLoanPersonalData.setMartialStatus(newLoanApplyPersonalData.getMartialStatus());
		newHomeLoanPersonalData.setMobileNumber(newLoanApplyPersonalData.getMobileNumber());
		newHomeLoanPersonalData.setPanNumber(newLoanApplyPersonalData.getPanNumber());

		return "Success";

	}

	public String applyIncomeData(HomeloanApplyIncomeDTO newLoanApplyIncomeData) {

		newHomeLoanIncomeData = new HomeloanApplyIncomeDatas();

//		BeanUtils.copyProperties(newHomeLoanPersonalData, newHomeLoanIncomeData);
		newHomeLoanIncomeData.setAnnualIncome(newLoanApplyIncomeData.getAnnualIncome());
		newHomeLoanIncomeData.setEmploymentType(newLoanApplyIncomeData.getEmploymentType());
		newHomeLoanIncomeData.setYearsOfExperience(newLoanApplyIncomeData.getYearsOfExperience());

		return "Success";

	}

	public String applyHomeData(HomeloanApplyHomeDTO newLoanApplyHomeData) {

		newHomeLoanHomeData = new HomeloanApplyHomeDatas();

//		BeanUtils.copyProperties(newHomeLoanIncomeData, newHomeLoanHomeData);
		newHomeLoanHomeData.setEstimatedConstructionCost(newLoanApplyHomeData.getEstimatedConstructionCost());
		newHomeLoanHomeData.setLandOwnerName(newLoanApplyHomeData.getLandOwnerName());
		newHomeLoanHomeData.setPropertyLocation(newLoanApplyHomeData.getPropertyLocation());

		return "Success";
	}

	public String applyLoanData(HomeloanApplyLoanDTO newLoanApplyLoanData) {

		newHomeLoanLoanData = new HomeloanApplyLoanDatas();

//		BeanUtils.copyProperties(newHomeLoanHomeData, newHomeLoanLoanData);
		newHomeLoanLoanData.setLoanAmount(newLoanApplyLoanData.getLoanAmount());
		newHomeLoanLoanData.setBankAccountNumber(newLoanApplyLoanData.getBankAccountNumber());
		newHomeLoanLoanData.setBankIFSCcode(newLoanApplyLoanData.getBankIFSCcode());
		newHomeLoanLoanData.setBankName(newLoanApplyLoanData.getBankName());
		newHomeLoanLoanData.setTenure(newLoanApplyLoanData.getTenure());
		newHomeLoanLoanData.setLoanStatus(LoanStatus.PENDING);
		newHomeLoanLoanData.setLoanReferenceId(HomeloanApplyDecisionService.generateLoanReferenceId());
		newHomeLoanLoanData.setCibilScore(HomeloanApplyDecisionService.generateCibilScore());
		newHomeLoanLoanData.setAppliedDateAndTime(LocalDateTime.now());

		newHomeLoanLoanData.setPersonalData(newHomeLoanPersonalData);
		newHomeLoanLoanData.setIncomeData(newHomeLoanIncomeData);
		newHomeLoanLoanData.setHomeData(newHomeLoanHomeData);

		if (HomeloanApplyDecisionService.checkEligibilityForLoan(newHomeLoanPersonalData, newHomeLoanIncomeData,
				newHomeLoanHomeData, newHomeLoanLoanData)) {

			homeloanApplyRepository.save(newHomeLoanLoanData);

			LoanApplyResponseDTO loanResponse = new LoanApplyResponseDTO();

			loanResponse.setLoanId(newHomeLoanLoanData.getLoanReferenceId());
			loanResponse.setCibilScore(newHomeLoanLoanData.getCibilScore());
			loanResponse.setLoanStatus(newHomeLoanLoanData.getLoanStatus());
			loanResponse.setMessage(HomeloanApplyDecisionService.message);
			loanResponse.setAppliedDate(newHomeLoanLoanData.getAppliedDateAndTime());

			return "Your Details Has Been Added Successfully " + loanResponse;
		} else {
			LoanApplyResponseDTO loanResponse = new LoanApplyResponseDTO();
			loanResponse.setMessage(HomeloanApplyDecisionService.message);
			return "" + loanResponse.getMessage();
		}
	}

	public HomeloanGetApplyDetails getTheLoanDetails(Integer id) {

		HomeloanApplyLoanDatas getLoanDatas = homeloanApplyRepository.findById(id)
				.orElseThrow(() -> new LoanNotFoundException("Not found.."));

		HomeloanApplyPersonalDatas getPersonalDatas = getLoanDatas.getPersonalData();

		HomeloanApplyHomeDatas getHomDatas = getLoanDatas.getHomeData();

		HomeloanApplyIncomeDatas getIncomeDatas = getLoanDatas.getIncomeData();

		HomeloanGetApplyDetails getData = new HomeloanGetApplyDetails(getPersonalDatas.getFullName(), getPersonalDatas.getMobileNumber(),
				getHomDatas.getLandOwnerName(), getLoanDatas.getCibilScore(), getLoanDatas.getBankName(), getLoanDatas.getLoanReferenceId(),
				getLoanDatas.getLoanStatus(), getLoanDatas.getAppliedDateAndTime());

		return getData;
	}

}
