package com.loan_eligibility_system_homeloan.service;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.loan_eligibility_system_homeloan.beans.HomeloanApplyHomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyIncomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyPersonalDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.repository.HomeloanApplyRepository;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyRequestDTO;
import com.loan_eligibility_system_homeloan.responseDTO.LoanApplyResponseDTO;
import com.loan_eligibility_system_homeloan.service_repository.HomeloanApplyServiceRepository;

@Service
public class HomeloanApplyService implements HomeloanApplyServiceRepository{

	private HomeloanApplyRepository homeloanApplyRepository;
	
	
	public HomeloanApplyService(HomeloanApplyRepository homeloanApplyRepository) {
		
		this.homeloanApplyRepository = homeloanApplyRepository;
		
	}

	public String applyLoan(HomeloanApplyRequestDTO newLoanApplyData) {
		
		HomeloanApplyPersonalDatas newHomeLoanPersonalData = new HomeloanApplyPersonalDatas();
		newHomeLoanPersonalData.setFullName(newLoanApplyData.getFullName());
		newHomeLoanPersonalData.setMailId(newLoanApplyData.getMailId());
		newHomeLoanPersonalData.setGender(newLoanApplyData.getGender());
		newHomeLoanPersonalData.setAadharNumber(newLoanApplyData.getAadharNumber());
		newHomeLoanPersonalData.setDateOfBirth(newLoanApplyData.getDateOfBirth());
		newHomeLoanPersonalData.setMartialStatus(newLoanApplyData.getMartialStatus());
		newHomeLoanPersonalData.setMobileNumber(newLoanApplyData.getMobileNumber());
		newHomeLoanPersonalData.setPanNumber(newLoanApplyData.getPanNumber());

		HomeloanApplyIncomeDatas newHomeLoanIncomeData = new HomeloanApplyIncomeDatas();
		newHomeLoanIncomeData.setAnnualIncome(newLoanApplyData.getAnnualIncome());
		newHomeLoanIncomeData.setEmploymentType(newLoanApplyData.getEmploymentType());
		newHomeLoanIncomeData.setYearsOfExperience(newLoanApplyData.getYearsOfExperience());

		HomeloanApplyHomeDatas newHomeLoanHomeData = new HomeloanApplyHomeDatas();
		newHomeLoanHomeData.setEstimatedConstructionCost(newLoanApplyData.getEstimatedConstructionCost());
		newHomeLoanHomeData.setLandOwnerName(newLoanApplyData.getLandOwnerName());
		newHomeLoanHomeData.setPropertyLocation(newLoanApplyData.getPropertyLocation());

		HomeloanApplyLoanDatas newHomeLoanLoanData = new HomeloanApplyLoanDatas();
		newHomeLoanLoanData.setLoanAmount(newLoanApplyData.getLoanAmount());
		newHomeLoanLoanData.setBankAccountNumber(newLoanApplyData.getBankAccountNumber());
		newHomeLoanLoanData.setBankIFSCcode(newLoanApplyData.getBankIFSCcode());
		newHomeLoanLoanData.setBankName(newLoanApplyData.getBankName());
		newHomeLoanLoanData.setTenure(newLoanApplyData.getTenure());
		newHomeLoanLoanData.setLoanStatus(LoanStatus.PENDING);
		newHomeLoanLoanData.setLoanReferenceId(HomeloanApplyService.generateLoanReferenceId());
		newHomeLoanLoanData.setCibilScore(HomeloanApplyService.generateCibilScore());

		newHomeLoanLoanData.setPersonalData(newHomeLoanPersonalData);
		newHomeLoanLoanData.setIncomeData(newHomeLoanIncomeData);
		newHomeLoanLoanData.setHomeData(newHomeLoanHomeData);

		homeloanApplyRepository.save(newHomeLoanLoanData);
		
		LoanApplyResponseDTO loanApplyResponse = new LoanApplyResponseDTO();
		
		loanApplyResponse.setLoanId(newHomeLoanLoanData.getLoanReferenceId());
		loanApplyResponse.setCibilScore(newHomeLoanLoanData.getCibilScore());
		loanApplyResponse.setLoanStatus(newHomeLoanLoanData.getLoanStatus());
		loanApplyResponse.setMessage(null);

		return "Your Details Has Been Added Successfully " + loanApplyResponse;
	}

	
	
	public static String generateLoanReferenceId() {

		int year = LocalDate.now().getYear();
		String prefix = "HMLN";
		String random = UUID.randomUUID().toString().substring(0,8).toUpperCase();
		return prefix+"_"+year+"_"+random;
	}

	public static int generateCibilScore() {

		Random generateRandomCibilScore = new Random();

		return generateRandomCibilScore.nextInt(100, 850);
	}

}
