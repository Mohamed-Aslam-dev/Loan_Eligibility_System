package com.loan_eligibility_system_homeloan.responseDTO;

import java.time.LocalDateTime;

import com.loan_eligibility_system_homeloan.enums.LoanStatus;

public class LoanApplyResponseDTO {

	private String loanId;
	private LoanStatus loanStatus;
	private Integer cibilScore;
	private String message;
	private LocalDateTime appliedDate;
	
	public LoanApplyResponseDTO() {
		
	}

	public LoanApplyResponseDTO(String loanId, LoanStatus loanStatus, Integer cibilScore, String message,
			LocalDateTime appliedDate) {
		
		this.loanId = loanId;
		this.loanStatus = loanStatus;
		this.cibilScore = cibilScore;
		this.message = message;
		this.appliedDate = appliedDate;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Integer getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(Integer cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDateTime appliedDate) {
		this.appliedDate = appliedDate;
	}

	@Override
	public String toString() {
		return "LoanApplyResponseDTO [loanId=" + loanId + ", loanStatus=" + loanStatus + ", cibilScore=" + cibilScore
				+ ", message=" + message + ", appliedDate=" + appliedDate + "]";
	}
	
	
	
	
}
