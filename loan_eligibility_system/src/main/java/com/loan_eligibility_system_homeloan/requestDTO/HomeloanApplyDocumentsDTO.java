package com.loan_eligibility_system_homeloan.requestDTO;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;

public class HomeloanApplyDocumentsDTO {

	@NotNull(message = "Aadhar front file is required.")

	private MultipartFile aadharFrontFile;

	@NotNull(message = "Aadhar back file is required.")

	private MultipartFile aadharBackFile;

	@NotNull(message = "PAN card file is required.")

	private MultipartFile panCardFile;

	@NotNull(message = "Property proof file is required.")

	private MultipartFile propertyProofFile;

	@NotNull(message = "Passport size photo is required.")

	private MultipartFile passportSizePhoto;

	public HomeloanApplyDocumentsDTO() {

	}

	public HomeloanApplyDocumentsDTO(@NotNull(message = "Aadhar front file is required.") MultipartFile aadharFrontFile,
			@NotNull(message = "Aadhar back file is required.") MultipartFile aadharBackFile,
			@NotNull(message = "PAN card file is required.") MultipartFile panCardFile,
			@NotNull(message = "Property proof file is required.") MultipartFile propertyProofFile,
			@NotNull(message = "Passport size photo is required.") MultipartFile passportSizePhoto) {
		this.aadharFrontFile = aadharFrontFile;
		this.aadharBackFile = aadharBackFile;
		this.panCardFile = panCardFile;
		this.propertyProofFile = propertyProofFile;
		this.passportSizePhoto = passportSizePhoto;
	}

	public MultipartFile getAadharFrontFile() {
		return aadharFrontFile;
	}

	public void setAadharFrontFile(MultipartFile aadharFrontFile) {
		this.aadharFrontFile = aadharFrontFile;
	}

	public MultipartFile getAadharBackFile() {
		return aadharBackFile;
	}

	public void setAadharBackFile(MultipartFile aadharBackFile) {
		this.aadharBackFile = aadharBackFile;
	}

	public MultipartFile getPanCardFile() {
		return panCardFile;
	}

	public void setPanCardFile(MultipartFile panCardFile) {
		this.panCardFile = panCardFile;
	}

	public MultipartFile getPropertyProofFile() {
		return propertyProofFile;
	}

	public void setPropertyProofFile(MultipartFile propertyProofFile) {
		this.propertyProofFile = propertyProofFile;
	}

	public MultipartFile getPassportSizePhoto() {
		return passportSizePhoto;
	}

	public void setPassportSizePhoto(MultipartFile passportSizePhoto) {
		this.passportSizePhoto = passportSizePhoto;
	}

	@Override
	public String toString() {
		return "HomeloanApplyDocumentsDTO [aadharFrontFile=" + aadharFrontFile + ", aadharBackFile=" + aadharBackFile
				+ ", panCardFile=" + panCardFile + ", propertyProofFile=" + propertyProofFile + ", passportSizePhoto="
				+ passportSizePhoto + "]";
	}

}
