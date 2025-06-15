package com.loan_eligibility_system_homeloan.beans;

import java.time.LocalDateTime;
import java.util.List;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	private LocalDateTime appliedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personal_id", referencedColumnName = "sNo")
	private HomeloanApplyPersonalDatas personalData;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "income_id", referencedColumnName = "sNo")
	private HomeloanApplyIncomeDatas incomeData;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "home_id", referencedColumnName = "sNo")
	private HomeloanApplyHomeDatas homeData;

	@OneToMany(mappedBy = "allLoanDatas", cascade = CascadeType.ALL)
	private List<HomeloanApplyDocuments> documents;

	public HomeloanApplyLoanDatas() {

	}

	public HomeloanApplyLoanDatas(Integer sNo, Double loanAmount, Integer tenure, Integer cibilScore,
			Long bankAccountNumber, String bankIFSCcode, String bankName, String loanReferenceId, LoanStatus status,
			LocalDateTime appliedDate, HomeloanApplyPersonalDatas personalData, HomeloanApplyIncomeDatas incomeData,
			HomeloanApplyHomeDatas homeData, List<HomeloanApplyDocuments> documents) {
		this.sNo = sNo;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.cibilScore = cibilScore;
		this.bankAccountNumber = bankAccountNumber;
		this.bankIFSCcode = bankIFSCcode;
		this.bankName = bankName;
		this.loanReferenceId = loanReferenceId;
		this.status = status;
		this.appliedDate = appliedDate;
		this.personalData = personalData;
		this.incomeData = incomeData;
		this.homeData = homeData;
		this.documents = documents;
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

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDateTime appliedDate) {
		this.appliedDate = appliedDate;
	}

	public HomeloanApplyPersonalDatas getPersonalData() {
		return personalData;
	}

	public void setPersonalData(HomeloanApplyPersonalDatas personalData) {
		this.personalData = personalData;
	}

	public HomeloanApplyIncomeDatas getIncomeData() {
		return incomeData;
	}

	public void setIncomeData(HomeloanApplyIncomeDatas incomeData) {
		this.incomeData = incomeData;
	}

	public HomeloanApplyHomeDatas getHomeData() {
		return homeData;
	}

	public void setHomeData(HomeloanApplyHomeDatas homeData) {
		this.homeData = homeData;
	}

	public List<HomeloanApplyDocuments> getDocuments() {
		return documents;
	}

	public void setDocuments(List<HomeloanApplyDocuments> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "HomeloanApplyLoanDatas [sNo=" + sNo + ", loanAmount=" + loanAmount + ", tenure=" + tenure
				+ ", cibilScore=" + cibilScore + ", bankAccountNumber=" + bankAccountNumber + ", bankIFSCcode="
				+ bankIFSCcode + ", bankName=" + bankName + ", loanReferenceId=" + loanReferenceId + ", status="
				+ status + ", appliedDate=" + appliedDate + ", personalData=" + personalData + ", incomeData="
				+ incomeData + ", homeData=" + homeData + ", documents=" + documents + "]";
	}

}
