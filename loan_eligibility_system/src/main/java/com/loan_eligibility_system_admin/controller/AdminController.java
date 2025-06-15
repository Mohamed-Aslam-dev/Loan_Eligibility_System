package com.loan_eligibility_system_admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loan_eligibility_system_admin.service.AdminService;
import com.loan_eligibility_system_any_queries.AnyQueries;
import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.responseDTO.HomeloanGetApplyDetails;

//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

//	@Autowired
//	AdminService adminService;
//	@Autowired
//	WorkerService workerService;
//	@Autowired
//	AgentService agentService;
//	@Autowired
//	FQAService faqService;
//	@Autowired
//	ReportService reportService;
//	@Autowired
//	BalanceSheetService balanceSheetService;

	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		Long pendingLoans = adminService.conutPendingLoans();
		Long approvedLoans = adminService.conutApprovedLoans();
		Long rejectedLoans = adminService.conutRejectedLoans();
		Long totalUsers = pendingLoans + approvedLoans + rejectedLoans;
		model.addAttribute("pendingLoans", pendingLoans);
		model.addAttribute("approvedLoans", approvedLoans);
		model.addAttribute("rejectedLoans", rejectedLoans);
		model.addAttribute("totalUsers", totalUsers);
		return "dashboard";
	}

	@GetMapping("/reports")
	public String reports() {
		return "Reports";
	}

	@GetMapping("/loan-list/{status}")
	public String getLoanListByStatus(@PathVariable String status, Model model) {
		LoanStatus loanStatus = LoanStatus.valueOf(status.toUpperCase());
		List<HomeloanApplyLoanDatas> loans = adminService.getPendingLoanDatas(loanStatus);

		model.addAttribute("loans", loans);
		model.addAttribute("statusLabel", status.toUpperCase());

		return "LoansList"; // Common JSP
	}
	
	@GetMapping("/fetchLoanData")
	public String fetchLoanData(@RequestParam String loanId, Model model) {
		HomeloanGetApplyDetails loanData = adminService.getTheLoanDetailsByRef(loanId);
		if (loanData != null) {
			model.addAttribute("loanData", loanData);
			return "FetchLoanDatas"; // JSP page name
		} else {
			model.addAttribute("error", "Loan ID not found.");
			return "dashboard"; // Redirect back to dashboard with error
		}
	}

	@GetMapping("/approved")
	public String getApprovedPage() {

		return "Approved-Confirmation";

	}

	@GetMapping("/rejected")
	public String getRejectedPage() {

		return "RejectedConfiramtion";

	}

	@PostMapping("/{loanRefID}/approve")
	public String loanApprovedRequest(@PathVariable String loanRefID) {
		adminService.loanApprovedRequest(loanRefID);
		return "redirect:/admin/approved";
	}

	@PostMapping("/{loanRefID}/reject")
	public String loanRejectRequest(@PathVariable String loanRefID) {
		adminService.loanRejectRequest(loanRefID);
		return "redirect:/admin/rejected";
	}

	@GetMapping("/getQueries")
	public String allQueries(Model model) {

		List<AnyQueries> allQuery = adminService.allQueries();
		model.addAttribute("queryList", allQuery);

		return "AllUserQueries";
	}

//	@GetMapping("/loans/pending")
//	@ResponseBody
//	public List<Admin> getPendingLoans(){
//		return adminService.getPendingLoans();
//		
//	}
//
//	@PostMapping("/loans/{loanId}")
//	@ResponseBody
//	public Admin getLoanById(@PathVariable String loanId, @RequestBody AdminApprovalRequest request) {
//		return adminService.approveLoan(loanId, request);
//		
//	}
//	 @PostMapping("/loans/{loanId}/reject")
//	 @ResponseBody
//	public Admin rejectLoan(@PathVariable String loanId,@RequestBody AdminApprovalRequest request) {
//		return adminService.rejectLoan(loanId, request);
//	}
//	 
//	 // ---------------------- Worker Assignment ----------------------
//	 
//	 @PostMapping("/assign")
//	 @ResponseBody
//	 public String assignLoanToWorker(@RequestParam String loanId, @RequestParam Long WorkerId, @RequestParam String assignedBy) {
//		return workerService.assignLoanToWorker(loanId, WorkerId, assignedBy);
//		 
//	 }
//	  
//	 @GetMapping("/worker/{workerId}/assignments")
//	@ResponseBody
//	 public List<LoanAssingment> getAssignments(@PathVariable Long workerId){
//		return workerService.getAssignmentsByWorkerId(workerId);
//		 
//	 }
//
//	// ---------------------- Worker Assignment ----------------------
//	 
//	 @PostMapping("/agent/comment")
//	 @ResponseBody
//	 public String saveAgentComment(@RequestParam String loanId, @RequestParam String agentName, @RequestParam String comment) {
//		return agentService.saveAgentComment(loanId, agentName, comment);
//		 
//	 }
//	 
//	 @GetMapping("/agent/comment/{loanId}")
//	@ResponseBody
//	 public List<AgentComment> getAgentComments(@PathVariable String loanId){
//		return agentService.getCommentsByLoanId(loanId);
//	 }
//	 
//	// ---------------------- FAQ Control ----------------------
//
//	 @PostMapping("/faq/add")
//	 @ResponseBody
//	 public FAQ addFAQ(@RequestBody FAQ faq) {
//		return faqService.addFAQ(faq.getQuestion(), faq.getAnswer());
//		 
//	 }
//	 @DeleteMapping("/faq/delete/{faqId}")
//	 @ResponseBody
//	 public String deleteFAQ(@PathVariable Long faqId) {
//		return faqService.deleteFAQ(faqId);
//		 
//	 }
//	 @GetMapping("/faq/all")
//	 @ResponseBody
//	 public List<FAQ> getAllFAQs(){
//		return faqService.getAllFAQs();
//		 
//	 }
//	 
//	// ---------------------- Reports ----------------------
//	 @GetMapping("/report/status")
//	 @ResponseBody
//	 public Map<String, Long> getStatusReport(){
//		return reportService.getLoanStatusReport();
//		 
//	 }
//	 
//	// ---------------------- Balance Sheet ----------------------
//
//	 @GetMapping("/report/balancesheet")
//	 @ResponseBody
//	 public Map<String,Object> getBalaneSheet(){
//		return balanceSheetService.getBalanceSheet();
//		 
//	 }

}
