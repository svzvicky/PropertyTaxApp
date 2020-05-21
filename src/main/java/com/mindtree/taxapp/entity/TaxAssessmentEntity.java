package com.mindtree.taxapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxassessment")
public class TaxAssessmentEntity {
	
	@Id
	@Column(name="AssesmentID")
	private int AssessmentID;

	
	@Column(name="AssessmentYear")
	private int AssessmentYear;
	
	@Column(name="OwnerName")
	private String ownerName;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="PropertyAddress")
	private String propertyAddress;
	
	@Column(name="Zone")
	private String zone;
	
	@Column(name="PropertyDescription")
	private String propertyDescription;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="BuildingConstructedYear")
	private int buildingConstructedYear;
	
	@Column(name="BuildingArea")
	private int buildingArea;
	
	@Column(name="TotalTax")
	private float totalTax;
	
	public int getAssessmentID() {
		return AssessmentID;
	}

	public void setAssessmentID(int assessmentID) {
		AssessmentID = assessmentID;
	}

	public int getAssessmentYear() {
		return AssessmentYear;
	}

	public void setAssessmentYear(int assessmentYear) {
		AssessmentYear = assessmentYear;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBuildingConstructedYear() {
		return buildingConstructedYear;
	}

	public void setBuildingConstructedYear(int buildingConstructedYear) {
		this.buildingConstructedYear = buildingConstructedYear;
	}

	public int getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(int buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AssessmentID;
		result = prime * result + AssessmentYear;
		result = prime * result + buildingArea;
		result = prime * result + buildingConstructedYear;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + ((propertyAddress == null) ? 0 : propertyAddress.hashCode());
		result = prime * result + ((propertyDescription == null) ? 0 : propertyDescription.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + Float.floatToIntBits(totalTax);
		result = prime * result + ((zone == null) ? 0 : zone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxAssessmentEntity other = (TaxAssessmentEntity) obj;
		if (AssessmentID != other.AssessmentID)
			return false;
		if (AssessmentYear != other.AssessmentYear)
			return false;
		if (buildingArea != other.buildingArea)
			return false;
		if (buildingConstructedYear != other.buildingConstructedYear)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (propertyAddress == null) {
			if (other.propertyAddress != null)
				return false;
		} else if (!propertyAddress.equals(other.propertyAddress))
			return false;
		if (propertyDescription == null) {
			if (other.propertyDescription != null)
				return false;
		} else if (!propertyDescription.equals(other.propertyDescription))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Float.floatToIntBits(totalTax) != Float.floatToIntBits(other.totalTax))
			return false;
		if (zone == null) {
			if (other.zone != null)
				return false;
		} else if (!zone.equals(other.zone))
			return false;
		return true;
	}

}
