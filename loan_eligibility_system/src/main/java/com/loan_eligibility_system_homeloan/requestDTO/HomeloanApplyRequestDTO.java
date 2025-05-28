package com.loan_eligibility_system_homeloan.requestDTO;

import java.util.Date;

import com.loan_eligibility_system_homeloan.enums.EmploymentType;
import com.loan_eligibility_system_homeloan.enums.LoanStatus;
import com.loan_eligibility_system_homeloan.enums.MartialStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class HomeloanApplyRequestDTO {

	@NotBlank(message = "Please Enter Your Full Name")
	private String fullName;

	@NotBlank(message = "Please Enter Your Email")
	@Email(message = "Enter a valid email address")
	private String mailId;

	@NotNull(message = "Please Enter Your Mobile Number")
	@Digits(integer = 10, fraction = 0, message = "Mobile number should be 10 digits")
	@Min(value = 1000000000L, message = "Mobile number should be 10 digits")
	private Long mobileNumber;

	@NotNull(message = "Please Enter Your Date of Birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@NotBlank(message = "Please Enter Your Gender")
	private String gender;

	@NotNull(message = "Please Select Your Marital Status")
	@Enumerated(EnumType.STRING)
	private MartialStatus martialStatus;

	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Enter a valid PAN number (e.g., ABCDE1234F)")
	private String panNumber;

	@Pattern(regexp = "\\d{12}", message = "Aadhar number should be 12 digits")
	private String aadharNumber;

	@NotNull(message = "Please Select Your Employment Type")
	@Enumerated(EnumType.STRING)
	private EmploymentType employmentType;

	@NotNull(message = "Please Enter Your Annual Income")
	@Positive(message = "Annual Income must be positive")
	private Double annualIncome;

	@Pattern(regexp = "\\d{1,2}", message = "Enter years of experience as a number (e.g., 5, 10)")
	private String yearsOfExperience;

	@Positive(message = "Estimated Construction Cost must be positive")
	private Double estimatedConstructionCost;

	@NotNull(message = "Please Enter Property Location")
	@NotBlank(message = "Please Enter Property Location")
	private String propertyLocation;

	@NotNull(message = "Please Enter Land Owner Name")
	@NotBlank(message = "Please Enter Land Owner Name")
	private String landOwnerName;

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

	@NotNull(message = "Loan Reference ID cannot be empty")
	@NotBlank(message = "Loan Reference ID cannot be empty")
	private String loanReferenceId;

	private LoanStatus loanStatus;

	public HomeloanApplyRequestDTO() {

	}

	public HomeloanApplyRequestDTO(@NotBlank(message = "Please Enter Your Full Name") String fullName,
			@NotBlank(message = "Please Enter Your Email") @Email(message = "Enter a valid email address") String mailId,
			@NotNull(message = "Please Enter Your Mobile Number") @Digits(integer = 10, fraction = 0, message = "Mobile number should be 10 digits") @Min(value = 1000000000, message = "Mobile number should be 10 digits") Long mobileNumber,
			@NotNull(message = "Please Enter Your Date of Birth") Date dateOfBirth,
			@NotBlank(message = "Please Enter Your Gender") String gender,
			@NotNull(message = "Please Select Your Marital Status") MartialStatus martialStatus,
			@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Enter a valid PAN number (e.g., ABCDE1234F)") String panNumber,
			@Pattern(regexp = "\\d{12}", message = "Aadhar number should be 12 digits") String aadharNumber,
			@NotNull(message = "Please Select Your Employment Type") EmploymentType employmentType,
			@NotNull(message = "Please Enter Your Annual Income") @Positive(message = "Annual Income must be positive") Double annualIncome,
			@Pattern(regexp = "\\d{1,2}", message = "Enter years of experience as a number (e.g., 5, 10)") String yearsOfExperience,
			@Positive(message = "Estimated Construction Cost must be positive") Double estimatedConstructionCost,
			@NotNull(message = "Please Enter Property Location") @NotBlank(message = "Please Enter Property Location") String propertyLocation,
			@NotNull(message = "Please Enter Land Owner Name") @NotBlank(message = "Please Enter Land Owner Name") String landOwnerName,
			@Positive(message = "Loan Amount must be positive") Double loanAmount,
			@Positive(message = "Tenure must be positive") Integer tenure,
			@Min(value = 300, message = "CIBIL score must be at least 300") @Max(value = 900, message = "CIBIL score must not exceed 900") Integer cibilScore,
			@NotNull(message = "Please Enter Your Bank Account Number") @Digits(integer = 18, fraction = 0, message = "Enter a valid bank account number") Long bankAccountNumber,
			@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Enter a valid IFSC code (e.g., HDFC0001234)") String bankIFSCcode,
			@NotNull(message = "Please Enter Bank Name") @NotBlank(message = "Please Enter Bank Name") String bankName,
			@NotNull(message = "Loan Reference ID cannot be empty") @NotBlank(message = "Loan Reference ID cannot be empty") String loanReferenceId,
			LoanStatus loanStatus) {
		this.fullName = fullName;
		this.mailId = mailId;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.martialStatus = martialStatus;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.employmentType = employmentType;
		this.annualIncome = annualIncome;
		this.yearsOfExperience = yearsOfExperience;
		this.estimatedConstructionCost = estimatedConstructionCost;
		this.propertyLocation = propertyLocation;
		this.landOwnerName = landOwnerName;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.cibilScore = cibilScore;
		this.bankAccountNumber = bankAccountNumber;
		this.bankIFSCcode = bankIFSCcode;
		this.bankName = bankName;
		this.loanReferenceId = loanReferenceId;
		this.loanStatus = loanStatus;
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

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Double getEstimatedConstructionCost() {
		return estimatedConstructionCost;
	}

	public void setEstimatedConstructionCost(Double estimatedConstructionCost) {
		this.estimatedConstructionCost = estimatedConstructionCost;
	}

	public String getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public String getLandOwnerName() {
		return landOwnerName;
	}

	public void setLandOwnerName(String landOwnerName) {
		this.landOwnerName = landOwnerName;
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

	@Override
	public String toString() {
		return "HomeLoanApplyRequestDTO [fullName=" + fullName + ", mailId=" + mailId + ", mobileNumber=" + mobileNumber
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", martialStatus=" + martialStatus
				+ ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + ", employmentType=" + employmentType
				+ ", annualIncome=" + annualIncome + ", yearsOfExperience=" + yearsOfExperience
				+ ", estimatedConstructionCost=" + estimatedConstructionCost + ", propertyLocation=" + propertyLocation
				+ ", landOwnerName=" + landOwnerName + ", loanAmount=" + loanAmount + ", tenure=" + tenure
				+ ", cibilScore=" + cibilScore + ", bankAccountNumber=" + bankAccountNumber + ", bankIFSCcode="
				+ bankIFSCcode + ", bankName=" + bankName + ", loanReferenceId=" + loanReferenceId + ", loanStatus="
				+ loanStatus + "]";
	}

}
