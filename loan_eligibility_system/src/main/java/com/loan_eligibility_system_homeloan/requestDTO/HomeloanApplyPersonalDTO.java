package com.loan_eligibility_system_homeloan.requestDTO;

import java.time.LocalDate;
import com.loan_eligibility_system_homeloan.enums.MartialStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class HomeloanApplyPersonalDTO {

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
	private LocalDate dateOfBirth;

	@NotBlank(message = "Please Enter Your Gender")
	private String gender;

	@NotNull(message = "Please Select Your Marital Status")
	@Enumerated(EnumType.STRING)
	private MartialStatus martialStatus;

	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Enter a valid PAN number (e.g., ABCDE1234F)")
	private String panNumber;

	@Pattern(regexp = "\\d{12}", message = "Aadhar number should be 12 digits")
	private String aadharNumber;

	public HomeloanApplyPersonalDTO() {

	}

	public HomeloanApplyPersonalDTO(@NotBlank(message = "Please Enter Your Full Name") String fullName,
			@NotBlank(message = "Please Enter Your Email") @Email(message = "Enter a valid email address") String mailId,
			@NotNull(message = "Please Enter Your Mobile Number") @Digits(integer = 10, fraction = 0, message = "Mobile number should be 10 digits") @Min(value = 1000000000, message = "Mobile number should be 10 digits") Long mobileNumber,
			@NotNull(message = "Please Enter Your Date of Birth") LocalDate dateOfBirth,
			@NotBlank(message = "Please Enter Your Gender") String gender,
			@NotNull(message = "Please Select Your Marital Status") MartialStatus martialStatus,
			@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Enter a valid PAN number (e.g., ABCDE1234F)") String panNumber,
			@Pattern(regexp = "\\d{12}", message = "Aadhar number should be 12 digits") String aadharNumber) {
		super();
		this.fullName = fullName;
		this.mailId = mailId;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.martialStatus = martialStatus;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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
		return "HomeloanApplyPersonalDTO [fullName=" + fullName + ", mailId=" + mailId + ", mobileNumber="
				+ mobileNumber + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", martialStatus="
				+ martialStatus + ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + "]";
	}

}
