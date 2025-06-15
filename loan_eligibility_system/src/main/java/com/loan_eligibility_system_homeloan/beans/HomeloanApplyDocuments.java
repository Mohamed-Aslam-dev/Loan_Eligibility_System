package com.loan_eligibility_system_homeloan.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HomeloanApplyDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;

	private String aadharFrontFilePath;
	private String aadharBackFilePath;
	private String panCardFilePath;
	private String propertyProofFilePath;
	private String passportPhotoFilePath;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_data_id") // foreign key column name
	private HomeloanApplyLoanDatas allLoanDatas;

	public HomeloanApplyDocuments() {

	}

	public HomeloanApplyDocuments(Integer sNo, String aadharFrontFilePath, String aadharBackFilePath,
			String panCardFilePath, String propertyProofFilePath, String passportPhotoFilePath,
			HomeloanApplyLoanDatas allLoanDatas) {
		this.sNo = sNo;
		this.aadharFrontFilePath = aadharFrontFilePath;
		this.aadharBackFilePath = aadharBackFilePath;
		this.panCardFilePath = panCardFilePath;
		this.propertyProofFilePath = propertyProofFilePath;
		this.passportPhotoFilePath = passportPhotoFilePath;
		this.allLoanDatas = allLoanDatas;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getAadharFrontFilePath() {
		return aadharFrontFilePath;
	}

	public void setAadharFrontFilePath(String aadharFrontFilePath) {
		this.aadharFrontFilePath = aadharFrontFilePath;
	}

	public String getAadharBackFilePath() {
		return aadharBackFilePath;
	}

	public void setAadharBackFilePath(String aadharBackFilePath) {
		this.aadharBackFilePath = aadharBackFilePath;
	}

	public String getPanCardFilePath() {
		return panCardFilePath;
	}

	public void setPanCardFilePath(String panCardFilePath) {
		this.panCardFilePath = panCardFilePath;
	}

	public String getPropertyProofFilePath() {
		return propertyProofFilePath;
	}

	public void setPropertyProofFilePath(String propertyProofFilePath) {
		this.propertyProofFilePath = propertyProofFilePath;
	}

	public String getPassportPhotoFilePath() {
		return passportPhotoFilePath;
	}

	public void setPassportPhotoFilePath(String passportPhotoFilePath) {
		this.passportPhotoFilePath = passportPhotoFilePath;
	}

	public HomeloanApplyLoanDatas getAllLoanDatas() {
		return allLoanDatas;
	}

	public void setAllLoanDatas(HomeloanApplyLoanDatas allLoanDatas) {
		this.allLoanDatas = allLoanDatas;
	}

	@Override
	public String toString() {
		return "HomeloanApplyDocuments [sNo=" + sNo + ", aadharFrontFilePath=" + aadharFrontFilePath
				+ ", aadharBackFilePath=" + aadharBackFilePath + ", panCardFilePath=" + panCardFilePath
				+ ", propertyProofFilePath=" + propertyProofFilePath + ", passportPhotoFilePath="
				+ passportPhotoFilePath + ", allLoanDatas=" + allLoanDatas + "]";
	}

}
