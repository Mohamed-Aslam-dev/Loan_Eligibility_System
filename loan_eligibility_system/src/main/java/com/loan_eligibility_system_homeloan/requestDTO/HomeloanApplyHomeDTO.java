package com.loan_eligibility_system_homeloan.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class HomeloanApplyHomeDTO {

	@Positive(message = "Estimated Construction Cost must be positive")
	private Double estimatedConstructionCost;

	@NotNull(message = "Please Enter Property Location")
	@NotBlank(message = "Please Enter Property Location")
	private String propertyLocation;

	@NotNull(message = "Please Enter Land Owner Name")
	@NotBlank(message = "Please Enter Land Owner Name")
	private String landOwnerName;

	public HomeloanApplyHomeDTO() {

	}

	public HomeloanApplyHomeDTO(
			@Positive(message = "Estimated Construction Cost must be positive") Double estimatedConstructionCost,
			@NotNull(message = "Please Enter Property Location") @NotBlank(message = "Please Enter Property Location") String propertyLocation,
			@NotNull(message = "Please Enter Land Owner Name") @NotBlank(message = "Please Enter Land Owner Name") String landOwnerName) {
		this.estimatedConstructionCost = estimatedConstructionCost;
		this.propertyLocation = propertyLocation;
		this.landOwnerName = landOwnerName;
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

	@Override
	public String toString() {
		return "HomeLoanApplyHomeRequestDTO [estimatedConstructionCost=" + estimatedConstructionCost
				+ ", propertyLocation=" + propertyLocation + ", landOwnerName=" + landOwnerName + "]";
	}

}
