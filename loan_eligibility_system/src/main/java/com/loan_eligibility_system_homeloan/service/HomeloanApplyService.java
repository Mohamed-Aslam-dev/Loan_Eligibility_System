package com.loan_eligibility_system_homeloan.service;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.loan_eligibility_system_homeloan.beans.HomeloanApplyHomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyIncomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyPersonalDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.repository.HomeloanApplyRepository;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyRequestDTO;
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
		BeanUtils.copyProperties(newHomeLoanHomeData, newHomeLoanLoanData);
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

		return "Your Details Has Been Added Successfully " + newHomeLoanLoanData;
	}

	public static String generateLoanReferenceId() {

		Random generateLoanRefId = new Random();
		int generatedRefId = generateLoanRefId.nextInt(1000, 9999);

		return "HMLN" + generatedRefId;
	}

	public static int generateCibilScore() {

		Random generateRandomCibilScore = new Random();

		return generateRandomCibilScore.nextInt(100, 850);
	}

}
