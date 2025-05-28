package com.loan_eligibility_system_homeloan.beans;

import java.util.Date;

import com.loan_eligibility_system_homeloan.enums.MartialStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class HomeloanApplyPersonalDatas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
	private String fullName;
	private String mailId;
	private Long mobileNumber;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String gender;
	private MartialStatus martialStatus;
	private String panNumber;
	private String aadharNumber;

	public HomeloanApplyPersonalDatas() {

	}

	public HomeloanApplyPersonalDatas(Integer sNo, String fullName, String mailId, Long mobileNumber, Date dateOfBirth,
			String gender, MartialStatus martialStatus, String panNumber, String aadharNumber) {
		super();
		this.sNo = sNo;
		this.fullName = fullName;
		this.mailId = mailId;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.martialStatus = martialStatus;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
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

	public MartialStatus getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(MartialStatus martialStatus) {
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

	@Override
	public String toString() {
		return "HomeloanApplyPersonalDatas [sNo=" + sNo + ", fullName=" + fullName + ", mailId=" + mailId
				+ ", mobileNumber=" + mobileNumber + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", martialStatus=" + martialStatus + ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber
				+ "]";
	}

}
