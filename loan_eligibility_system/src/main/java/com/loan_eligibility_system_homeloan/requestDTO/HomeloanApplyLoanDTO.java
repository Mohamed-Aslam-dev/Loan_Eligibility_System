package com.loan_eligibility_system_homeloan.requestDTO;

import java.time.LocalDateTime;

import com.loan_eligibility_system_homeloan.enums.LoanStatus;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class HomeloanApplyLoanDTO {

	@Positive(message = "Loan Amount must be positive")
	private Double loanAmount;

	@Positive(message = "Tenure must be positive")
	private Integer tenure;

	@Min(value = 300, message = "CIBIL score must be at least 300")
	@Max(value = 900, message = "CIBIL score must not exceed 900")
	private Integer cibilScore;

	@NotNull(message = "Please Enter Your Bank Account Number")
	@Digits(integer = 18, fraction = 0, message = "Enter a valid bank account number")
	private Long bankAccountNumber;

	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Enter a valid IFSC code (e.g., HDFC0001234)")
	private String bankIFSCcode;

	@NotNull(message = "Please Enter Bank Name")
	@NotBlank(message = "Please Enter Bank Name")
	private String bankName;

	private String loanReferenceId;

	private LoanStatus loanStatus;

	private LocalDateTime appliedDateAndTime;

	public HomeloanApplyLoanDTO() {

	}

	public HomeloanApplyLoanDTO(@Positive(message = "Loan Amount must be positive") Double loanAmount,
			@Positive(message = "Tenure must be positive") Integer tenure,
			@Min(value = 300, message = "CIBIL score must be at least 300") @Max(value = 900, message = "CIBIL score must not exceed 900") Integer cibilScore,
			@NotNull(message = "Please Enter Your Bank Account Number") @Digits(integer = 18, fraction = 0, message = "Enter a valid bank account number") Long bankAccountNumber,
			@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Enter a valid IFSC code (e.g., HDFC0001234)") String bankIFSCcode,
			@NotNull(message = "Please Enter Bank Name") @NotBlank(message = "Please Enter Bank Name") String bankName,
			String loanReferenceId, LoanStatus loanStatus, LocalDateTime appliedDateAndTime) {
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.cibilScore = cibilScore;
		this.bankAccountNumber = bankAccountNumber;
		this.bankIFSCcode = bankIFSCcode;
		this.bankName = bankName;
		this.loanReferenceId = loanReferenceId;
		this.loanStatus = loanStatus;
		this.appliedDateAndTime = appliedDateAndTime;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Integer getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(Integer cibilScore) {
		this.cibilScore = cibilScore;
	}

	public Long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIFSCcode() {
		return bankIFSCcode;
	}

	public void setBankIFSCcode(String bankIFSCcode) {
		this.bankIFSCcode = bankIFSCcode;
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
		return "HomeloanApplyLoanDTO [loanAmount=" + loanAmount + ", tenure=" + tenure + ", cibilScore=" + cibilScore
				+ ", bankAccountNumber=" + bankAccountNumber + ", bankIFSCcode=" + bankIFSCcode + ", bankName="
				+ bankName + ", loanReferenceId=" + loanReferenceId + ", loanStatus=" + loanStatus
				+ ", appliedDateAndTime=" + appliedDateAndTime + "]";
	}

}
