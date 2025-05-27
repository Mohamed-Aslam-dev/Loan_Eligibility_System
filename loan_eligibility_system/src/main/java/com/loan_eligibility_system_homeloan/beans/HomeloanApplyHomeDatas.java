package com.loan_eligibility_system_homeloan.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HomeloanApplyHomeDatas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
	private Double estimatedConstructionCost;
	private String propertyLocation;
	private String landOwnerName;

	public HomeloanApplyHomeDatas() {

	}

	public HomeloanApplyHomeDatas(Integer sNo, Double estimatedConstructionCost, String propertyLocation,
			String landOwnerName) {

		this.sNo = sNo;
		this.estimatedConstructionCost = estimatedConstructionCost;
		this.propertyLocation = propertyLocation;
		this.landOwnerName = landOwnerName;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
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
		return "HomeloanApplyHomeDatas [sNo=" + sNo + ", estimatedConstructionCost=" + estimatedConstructionCost
				+ ", propertyLocation=" + propertyLocation + ", landOwnerName=" + landOwnerName + "]";
	}

}
