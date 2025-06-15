package com.loan_eligibility_system_homeloan.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.loan_eligibility_system_exceptions.LoanNotFoundException;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyDocuments;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyHomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyIncomeDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyPersonalDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.repository.HomeloanApplyRepository;
import com.loan_eligibility_system_homeloan.repository.HomeloanDocumentsRepository;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyDocumentsDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyHomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyIncomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyLoanDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyPersonalDTO;
import com.loan_eligibility_system_homeloan.responseDTO.HomeloanGetApplyDetails;
import com.loan_eligibility_system_homeloan.responseDTO.LoanApplyResponseDTO;
import com.loan_eligibility_system_homeloan.service_repository.HomeloanApplyServiceRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class HomeloanApplyService implements HomeloanApplyServiceRepository {

	private HomeloanApplyRepository loanApplyRepository;
	private HomeloanDocumentsRepository documentsRepository;
	private HomeloanDocumentsStoredService storeDocumentsService;

	public HomeloanApplyService(HomeloanApplyRepository loanApplyRepository,
			HomeloanDocumentsRepository documentsRepository, HomeloanDocumentsStoredService storeDocumentsService) {
		this.loanApplyRepository = loanApplyRepository;
		this.documentsRepository = documentsRepository;
		this.storeDocumentsService = storeDocumentsService;
	}

	@Value("${file.upload.dir}")
	private String uploadDir;

	@Autowired
	private HomeloanApplyDecisionService loanDecisionService;

	public HomeloanApplyPersonalDatas applyPersonalData(HomeloanApplyPersonalDTO personalDTO) {
		HomeloanApplyPersonalDatas personalData = new HomeloanApplyPersonalDatas();
		personalData.setFullName(personalDTO.getFullName());
		personalData.setMailId(personalDTO.getMailId());
		personalData.setGender(personalDTO.getGender());
		personalData.setAadharNumber(personalDTO.getAadharNumber());
		personalData.setDateOfBirth(personalDTO.getDateOfBirth());
		personalData.setMartialStatus(personalDTO.getMartialStatus());
		personalData.setMobileNumber(personalDTO.getMobileNumber());
		personalData.setPanNumber(personalDTO.getPanNumber());
		return personalData;
	}

	public HomeloanApplyIncomeDatas applyIncomeData(HomeloanApplyIncomeDTO incomeDTO) {
		HomeloanApplyIncomeDatas incomeData = new HomeloanApplyIncomeDatas();
		incomeData.setAnnualIncome(incomeDTO.getAnnualIncome());
		incomeData.setEmploymentType(incomeDTO.getEmploymentType());
		incomeData.setYearsOfExperience(incomeDTO.getYearsOfExperience());
		return incomeData;
	}

	public HomeloanApplyHomeDatas applyHomeData(HomeloanApplyHomeDTO homeDTO) {
		HomeloanApplyHomeDatas homeData = new HomeloanApplyHomeDatas();
		homeData.setEstimatedConstructionCost(homeDTO.getEstimatedConstructionCost());
		homeData.setLandOwnerName(homeDTO.getLandOwnerName());
		homeData.setPropertyLocation(homeDTO.getPropertyLocation());
		return homeData;
	}

	@Transactional
	public LoanApplyResponseDTO finalLoanSubmission(HomeloanApplyPersonalDTO personalDTO, HomeloanApplyIncomeDTO incomeDTO,
			HomeloanApplyHomeDTO homeDTO, HomeloanApplyLoanDTO loanDTO, HomeloanApplyDocumentsDTO documentsDTO) {
		HomeloanApplyLoanDatas loanData = new HomeloanApplyLoanDatas();
		loanData.setLoanAmount(loanDTO.getLoanAmount());
		loanData.setBankAccountNumber(loanDTO.getBankAccountNumber());
		loanData.setBankIFSCcode(loanDTO.getBankIFSCcode());
		loanData.setBankName(loanDTO.getBankName());
		loanData.setTenure(loanDTO.getTenure());
		loanData.setStatus(LoanStatus.PENDING);
		loanData.setLoanReferenceId(loanDecisionService.generateLoanReferenceId());
		loanData.setCibilScore(loanDTO.getCibilScore());
		loanData.setAppliedDate(LocalDateTime.now());

		loanData.setPersonalData(applyPersonalData(personalDTO));
		loanData.setIncomeData(applyIncomeData(incomeDTO));
		loanData.setHomeData(applyHomeData(homeDTO));

		loanApplyRepository.save(loanData);

		applyDocuments(documentsDTO, loanData);

		LoanApplyResponseDTO loanResponse = new LoanApplyResponseDTO();
		loanResponse.setLoanId(loanData.getLoanReferenceId());
		loanResponse.setCibilScore(loanData.getCibilScore());
		loanResponse.setLoanStatus(loanData.getStatus());
		loanResponse.setMessage(loanDecisionService.getMessage());
		loanResponse.setAppliedDate(loanData.getAppliedDate());

		return loanResponse;
	}

	public HomeloanApplyDocuments applyDocuments(HomeloanApplyDocumentsDTO documentsDTO, HomeloanApplyLoanDatas loanData) {
		try {
			HomeloanApplyDocuments documents = new HomeloanApplyDocuments();

			String aadharFrontPath = storeDocumentsService.saveFile(documentsDTO.getAadharFrontFile(), uploadDir);
			String aadharBackPath = storeDocumentsService.saveFile(documentsDTO.getAadharBackFile(), uploadDir);
			String panCardPath = storeDocumentsService.saveFile(documentsDTO.getPanCardFile(), uploadDir);
			String propertyProofPath = storeDocumentsService.saveFile(documentsDTO.getPropertyProofFile(), uploadDir);
			String passportPhotoPath = storeDocumentsService.saveFile(documentsDTO.getPassportSizePhoto(), uploadDir);

//            // ❗ Null check
//            if (aadharFrontPath == null || aadharBackPath == null || panCardPath == null
//                    || propertyProofPath == null || passportPhotoPath == null) {
//                throw new RuntimeException("One or more files failed to upload.");
//            }

			documents.setAadharFrontFilePath(aadharFrontPath);
			documents.setAadharBackFilePath(aadharBackPath);
			documents.setPanCardFilePath(panCardPath);
			documents.setPropertyProofFilePath(propertyProofPath);
			documents.setPassportPhotoFilePath(passportPhotoPath);

			documents.setAllLoanDatas(loanData);
			return documentsRepository.save(documents);

		} catch (Exception e) {
			throw new RuntimeException("Failed to save documents: " + e.getMessage(), e);
		}
	}

	public boolean processBeforeOtpVerification(HomeloanApplyPersonalDTO personalDTO, HomeloanApplyIncomeDTO incomeDTO,
			HomeloanApplyHomeDTO homeDTO, HomeloanApplyLoanDTO loanDTO, HttpSession session) {
		int cibilScore = loanDecisionService.generateCibilScore();
		loanDTO.setCibilScore(cibilScore);

		boolean isEligible = loanDecisionService.checkEligibilityForLoan(personalDTO, incomeDTO, homeDTO, loanDTO);

		if (isEligible) {
			session.setAttribute("loanApplyPersonalDTO", personalDTO);
			session.setAttribute("loanApplyIncomeDTO", incomeDTO);
			session.setAttribute("loanApplyHomeDTO", homeDTO);
			session.setAttribute("loanApplyLoanDTO", loanDTO);
		}

		return isEligible;
	}

	public String getRejectionReason() {
		return loanDecisionService.getMessage();
	}

	public HomeloanGetApplyDetails getTheLoanDetails(Integer id) {
		HomeloanApplyLoanDatas test = loanApplyRepository.findById(id)
				.orElseThrow(() -> new LoanNotFoundException("Not found.."));
		HomeloanApplyPersonalDatas personal = test.getPersonalData();
		HomeloanApplyHomeDatas home = test.getHomeData();
		HomeloanApplyIncomeDatas income = test.getIncomeData();
		return new HomeloanGetApplyDetails(personal.getFullName(), personal.getMobileNumber(), home.getLandOwnerName(),
				test.getCibilScore(), test.getBankName(), test.getLoanReferenceId(), test.getStatus());
	}

	public HomeloanGetApplyDetails getTheLoanDetailsByRef(String loanReferenceId) {
		HomeloanApplyLoanDatas test = loanApplyRepository.findAllByLoanReferenceId(loanReferenceId)
				.orElseThrow(() -> new LoanNotFoundException("Not found.."));
		HomeloanApplyPersonalDatas personal = test.getPersonalData();
		HomeloanApplyHomeDatas home = test.getHomeData();
		HomeloanApplyIncomeDatas income = test.getIncomeData();
		return new HomeloanGetApplyDetails(personal.getFullName(), personal.getMobileNumber(), home.getLandOwnerName(),
				test.getCibilScore(), test.getBankName(), test.getLoanReferenceId(), test.getStatus());
	}

}
