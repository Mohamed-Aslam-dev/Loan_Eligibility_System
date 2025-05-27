package com.loan_eligibility_system_homeloan.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HomeloanApplyLoanDatas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
	private Double loanAmount;
	private Integer tenure;
	private Integer cibilScore;
	private Long bankAccountNumber;
	private String bankIFSCcode;
	private String bankName;
	private String loanReferenceId;
	private String status = "Pending";

	public HomeloanApplyLoanDatas() {

	}

	public HomeloanApplyLoanDatas(Integer sNo, Double loanAmount, Integer tenure, Integer cibilScore,
			Long bankAccountNumber, String bankIFSCcode, String bankName, String loanReferenceId, String status) {

		this.sNo = sNo;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.cibilScore = cibilScore;
		this.bankAccountNumber = bankAccountNumber;
		this.bankIFSCcode = bankIFSCcode;
		this.bankName = bankName;
		this.loanReferenceId = loanReferenceId;
		this.status = status;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HomeloanApplyLoanDatas [sNo=" + sNo + ", loanAmount=" + loanAmount + ", tenure=" + tenure
				+ ", cibilScore=" + cibilScore + ", bankAccountNumber=" + bankAccountNumber + ", bankIFSCcode="
				+ bankIFSCcode + ", bankName=" + bankName + ", loanReferenceId=" + loanReferenceId + ", status="
				+ status + "]";
	}

}
