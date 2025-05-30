package com.loan_eligibility_system_homeloan.responseDTO;

import java.time.LocalDateTime;

import com.loan_eligibility_system_homeloan.enums.LoanStatus;

public class HomeloanGetApplyDetails {

	private String fullName;
	private Long mobileNumber;
	private String landOwnerName;
	private Integer cibilScore;
	private String bankName;
	private String loanReferenceId;
	private LoanStatus loanStatus;
	private LocalDateTime appliedDateAndTime;

	public HomeloanGetApplyDetails() {

	}

	public HomeloanGetApplyDetails(String fullName, Long mobileNumber, String landOwnerName, Integer cibilScore,
			String bankName, String loanReferenceId, LoanStatus loanStatus, LocalDateTime appliedDateAndTime) {

		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.landOwnerName = landOwnerName;
		this.cibilScore = cibilScore;
		this.bankName = bankName;
		this.loanReferenceId = loanReferenceId;
		this.loanStatus = loanStatus;
		this.appliedDateAndTime = appliedDateAndTime;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLandOwnerName() {
		return landOwnerName;
	}

	public void setLandOwnerName(String landOwnerName) {
		this.landOwnerName = landOwnerName;
	}

	public Integer getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(Integer cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLoanReferenceId() {
		return loanReferenceId;
	}

	public void setLoanReferenceId(String loanReferenceId) {
		this.loanReferenceId = loanReferenceId;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	public LocalDateTime getAppliedDateAndTime() {
		return appliedDateAndTime;
	}

	public void setAppliedDateAndTime(LocalDateTime appliedDateAndTime) {
		this.appliedDateAndTime = appliedDateAndTime;
	}

	@Override
	public String toString() {
		return "HomeloanGetApplyDetails [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", landOwnerName="
				+ landOwnerName + ", cibilScore=" + cibilScore + ", bankName=" + bankName + ", loanReferenceId="
				+ loanReferenceId + ", loanStatus=" + loanStatus + ", appliedDateAndTime=" + appliedDateAndTime + "]";
	}

}
