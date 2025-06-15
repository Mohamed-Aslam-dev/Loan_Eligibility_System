package com.loan_eligibility_system_homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.loan_eligibility_system_email_verification.CacheOTPService;
import com.loan_eligibility_system_email_verification.EmailSenderService;
import com.loan_eligibility_system_homeloan.enums.EmploymentType;
import com.loan_eligibility_system_homeloan.enums.MartialStatus;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyDocumentsDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyHomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyIncomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyLoanDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyPersonalDTO;
import com.loan_eligibility_system_homeloan.responseDTO.LoanApplyResponseDTO;
import com.loan_eligibility_system_homeloan.service_repository.HomeloanApplyServiceRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({ "loanApplyPersonalDTO", "loanApplyIncomeDTO", "loanApplyHomeDTO", "loanApplyLoanDTO", "loanApplyDocumentsDTO" })
public class HomeloanApplyDataController {

	private HomeloanApplyServiceRepository homeloanApplyServiceRepository;
	
	public HomeloanApplyDataController(HomeloanApplyServiceRepository homeloanApplyServiceRepository) {
		
		this.homeloanApplyServiceRepository = homeloanApplyServiceRepository;
	}
	
	@Autowired
    private CacheOTPService cacheOTPService;

    @Autowired
    private EmailSenderService emailSenderService;

	@GetMapping
    public String accessjsp() {
        return "HomePage";
    }

    @GetMapping("/admin")
    public String redirectToDashboard() {
        return "redirect:/admin/dashboard";
    }
	
    @GetMapping("/homeloan/personal")
    public String personalForm(Model model) {
        model.addAttribute("martialStatuses", MartialStatus.values());
        if (!model.containsAttribute("loanApplyPersonalDTO")) {
            model.addAttribute("loanApplyPersonalDTO", new HomeloanApplyPersonalDTO());
        }
        return "HomeLoan/HomeloanPersonalForm";
    }

    @GetMapping("/homeloan/income")
    public String loadIncomeFormPartial(@ModelAttribute("loanApplyPersonalDTO") HomeloanApplyPersonalDTO personalDTO,
                                       Model model) {
        model.addAttribute("employmentTypes", EmploymentType.values());
        if (!model.containsAttribute("loanApplyIncomeDTO")) {
            model.addAttribute("loanApplyIncomeDTO", new HomeloanApplyIncomeDTO());
        }
        return "HomeLoan/HomeloanIncomeForm";
    }

    @GetMapping("/homeloan/home")
    public String loadHomeFormPartial(@ModelAttribute("loanApplyIncomeDTO") HomeloanApplyIncomeDTO incomeDTO, Model model) {
        if (!model.containsAttribute("loanApplyHomeDTO")) {
            model.addAttribute("loanApplyHomeDTO", new HomeloanApplyHomeDTO());
        }
        return "HomeLoan/HomeloanHomeForm";
    }

    @GetMapping("/homeloan/loan")
    public String loadLoanFormPartial(@ModelAttribute("loanApplyHomeDTO") HomeloanApplyHomeDTO homeDTO, Model model) {
        if (!model.containsAttribute("loanApplyLoanDTO")) {
            model.addAttribute("loanApplyLoanDTO", new HomeloanApplyLoanDTO());
        }
        return "HomeLoan/HomeloanLoanForm";
    }

    @GetMapping("/homeloan/documents")
    public String loadLoanDocumentsFormPartial(@ModelAttribute("loanApplyLoanDTO") HomeloanApplyLoanDTO loanDTO,
                                              Model model) {
        if (!model.containsAttribute("loanApplyDocumentsDTO")) {
            model.addAttribute("loanApplyDocumentsDTO", new HomeloanApplyDocumentsDTO());
        }
        return "HomeLoan/HomeloanDocumentsForm";
    }
    
    @PostMapping("/homeloan/apply/personal")
    public String submitPersonalForm(@Valid @ModelAttribute("loanApplyPersonalDTO") HomeloanApplyPersonalDTO personalDTO,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("martialStatuses", MartialStatus.values());
            return "HomeLoan/HomeloanPersonalForm";
        }
        return "redirect:/homeloan/income";
    }

    @PostMapping("/homeloan/apply/income")
    public String applyIncomeData(@Valid @ModelAttribute("loanApplyIncomeDTO") HomeloanApplyIncomeDTO newLoanApplyIncomeData,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employmentTypes", EmploymentType.values());
            return "HomeLoan/HomeloanIncomeForm";
        }
        return "redirect:/homeloan/home";
    }

    @PostMapping("/homeloan/apply/home")
    public String applyHomeData(@Valid @ModelAttribute("loanApplyHomeDTO") HomeloanApplyHomeDTO newLoanApplyHomeData,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "HomeLoan/HomeloanHomeForm";
        }
        return "redirect:/homeloan/loan";
    }

    @PostMapping("/homeloan/apply/loan")
    public String applyLoanData(@Valid @ModelAttribute("loanApplyLoanDTO") HomeloanApplyLoanDTO newLoanApplyLoanData,
                               @ModelAttribute("loanApplyPersonalDTO") HomeloanApplyPersonalDTO personalDTO,
                               @ModelAttribute("loanApplyIncomeDTO") HomeloanApplyIncomeDTO incomeDTO,
                               @ModelAttribute("loanApplyHomeDTO") HomeloanApplyHomeDTO homeDTO, BindingResult result,
                               Model model, HttpSession session, SessionStatus status) {
        if (result.hasErrors()) {
            return "HomeLoan/HomeloanLoanForm";
        }

        boolean eligible = homeloanApplyServiceRepository.processBeforeOtpVerification(personalDTO, incomeDTO, homeDTO,
                newLoanApplyLoanData, session);

        if (eligible) {
            return "redirect:/homeloan/documents";
        } else {
            LoanApplyResponseDTO rejectionResponse = new LoanApplyResponseDTO();
            rejectionResponse.setMessage(homeloanApplyServiceRepository.getRejectionReason());
            model.addAttribute("response", rejectionResponse);
            status.setComplete();
            return "HomeLoan/HomeloanRejectionPage";
        }
    }

    @PostMapping(value = "/homeloan/submit-documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String submitDocuments(@Valid @ModelAttribute("loanApplyDocumentsDTO") HomeloanApplyDocumentsDTO documentsDTO,
                                 BindingResult result, HttpSession session, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "HomeLoan/HomeloanDocumentsForm";
        }

        HomeloanApplyPersonalDTO personalDTO = (HomeloanApplyPersonalDTO) session.getAttribute("loanApplyPersonalDTO");
        if (personalDTO == null) {
            model.addAttribute("errorMessage", "Session expired. Please start over.");
            return "HomeLoan/HomeloanDocumentsForm";
        }

        session.setAttribute("loanApplyDocumentsDTO", documentsDTO);

        String otp = cacheOTPService.generateOTP(personalDTO.getMailId());
        emailSenderService.sendOTPToEmail(personalDTO.getMailId(), otp);
        session.setAttribute("otpEmail", personalDTO.getMailId());

        model.addAttribute("otpEmail", personalDTO.getMailId());
        return "HomeLoan/OtpVerificationForm";
    }

    @PostMapping("/homeloan/verify-otp")
    public String verifyOtpAndSubmit(@RequestParam("otp") String otp, HttpSession session, Model model,
                                    SessionStatus status) {
        String email = (String) session.getAttribute("otpEmail");
        if (email == null) {
            model.addAttribute("errorMessage", "Session expired or Email not found. Please reapply.");
            return "HomeLoan/OtpVerificationForm";
        }

        if (cacheOTPService.validateOTP(email, otp)) {
            HomeloanApplyPersonalDTO personalDTO = (HomeloanApplyPersonalDTO) session.getAttribute("loanApplyPersonalDTO");
            HomeloanApplyIncomeDTO incomeDTO = (HomeloanApplyIncomeDTO) session.getAttribute("loanApplyIncomeDTO");
            HomeloanApplyHomeDTO homeDTO = (HomeloanApplyHomeDTO) session.getAttribute("loanApplyHomeDTO");
            HomeloanApplyLoanDTO loanDTO = (HomeloanApplyLoanDTO) session.getAttribute("loanApplyLoanDTO");
            HomeloanApplyDocumentsDTO documentsDTO = (HomeloanApplyDocumentsDTO) session.getAttribute("loanApplyDocumentsDTO");

            if (personalDTO == null || incomeDTO == null || homeDTO == null || loanDTO == null || documentsDTO == null) {
                model.addAttribute("errorMessage", "Session data missing. Please start over.");
                return "HomeLoan/OtpVerificationForm";
            }

            try {
                LoanApplyResponseDTO response = homeloanApplyServiceRepository.finalLoanSubmission(personalDTO, incomeDTO, homeDTO,
                        loanDTO, documentsDTO);
                model.addAttribute("response", response);
                status.setComplete();
                session.invalidate();
                return "HomeLoan/HomeloanConfirmationPage";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMessage", "Error processing loan submission: " + e.getMessage());
                return "HomeLoan/OtpVerificationForm";
            }
        } else {
            model.addAttribute("errorMessage", "Invalid OTP. Please try again.");
            return "HomeLoan/OtpVerificationForm";
        }
    }
	
}
