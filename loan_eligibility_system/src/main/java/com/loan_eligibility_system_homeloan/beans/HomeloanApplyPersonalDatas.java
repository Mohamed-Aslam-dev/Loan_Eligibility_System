package com.loan_eligibility_system_homeloan.beans;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class HomeloanApplyPersonalDatas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
	private String fullName;
	private String mailId;
	private Long mobileNumber;
	private Date dateOfBirth;
	private String gender;
	private String martialStatus;
	private String panNumber;
	private String aadharNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personal_id", referencedColumnName = "sNo")
	private HomeloanApplyPersonalDatas personalData;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "income_id", referencedColumnName = "sNo")
	private HomeloanApplyIncomeDatas incomeData;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "home_id", referencedColumnName = "sNo")
	private HomeloanApplyHomeDatas homeData;

	public HomeloanApplyPersonalDatas() {
		
	}

	public HomeloanApplyPersonalDatas(Integer sNo, String fullName, String mailId, Long mobileNumber, Date dateOfBirth,
			String gender, String martialStatus, String panNumber, String aadharNumber,
			HomeloanApplyPersonalDatas personalData, HomeloanApplyIncomeDatas incomeData,
			HomeloanApplyHomeDatas homeData) {
		
		this.sNo = sNo;
		this.fullName = fullName;
		this.mailId = mailId;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.martialStatus = martialStatus;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.personalData = personalData;
		this.incomeData = incomeData;
		this.homeData = homeData;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
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

	@Override
	public String toString() {
		return "HomeloanApplyPersonalDatas [sNo=" + sNo + ", fullName=" + fullName + ", mailId=" + mailId
				+ ", mobileNumber=" + mobileNumber + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", martialStatus=" + martialStatus + ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber
				+ ", personalData=" + personalData + ", incomeData=" + incomeData + ", homeData=" + homeData + "]";
	}

}
