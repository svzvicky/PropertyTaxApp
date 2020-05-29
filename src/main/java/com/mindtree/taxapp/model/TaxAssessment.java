package com.mindtree.taxapp.model;

import java.util.Calendar;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TaxAssessment {
	
	private Integer yearofAssessment;

	@NotBlank(message="Please enter owner name")
	private String nameofOwner;

	@Pattern(regexp="^(.+)@(.+)$", message="Please enter valid email address")
	private String ownerEmail;

	@NotBlank(message="Please enter address")
	private String addressofProperty;

	private String zonalClassification;

	private String propertyDescription;
	
	private int categoryID;

	@NotBlank(message="Please select status")
	private String status;
	
	@Max(value= 2020, message="Year can't be future")
	@Min(value=1901, message="Please enter year after 1901 ")
	private Integer buildingConstructedYear;
	
	@NotNull(message="Please enter area")
	@Min(value=1)
	private Integer builtUpArea;

	private float totalTaxPayable;

	public TaxAssessment() {
		yearofAssessment = Calendar.getInstance().get(Calendar.YEAR);
		nameofOwner = "";
		addressofProperty = "";
		zonalClassification = "";
		propertyDescription = "";
		status = "";
		buildingConstructedYear = 0;
		builtUpArea = 0;
		totalTaxPayable = 0;
		categoryID=0;
	}

	public TaxAssessment(Integer yearofAssessment, String nameofOwner, String ownerEmail, String addressofProperty,
			String zonalClassification, String propertyDescription, String status, Integer buildingConstructedYear,
			Integer builtUpArea, float totalTaxPayable,int categoryID) {
		super();
		this.yearofAssessment = yearofAssessment;
		this.nameofOwner = nameofOwner;
		this.ownerEmail = ownerEmail;
		this.addressofProperty = addressofProperty;
		this.zonalClassification = zonalClassification;
		this.propertyDescription = propertyDescription;
		this.status = status;
		this.buildingConstructedYear = buildingConstructedYear;
		this.builtUpArea = builtUpArea;
		this.totalTaxPayable = totalTaxPayable;
		this.categoryID = categoryID;
	}

	public Integer getYearofAssessment() {
		return yearofAssessment;
	}

	public void setYearofAssessment(Integer yearofAssessment) {
		this.yearofAssessment = yearofAssessment;
	}

	public String getNameofOwner() {
		return nameofOwner;
	}

	public void setNameofOwner(String nameofOwner) {
		this.nameofOwner = nameofOwner;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getAddressofProperty() {
		return addressofProperty;
	}

	public void setAddressofProperty(String addressofProperty) {
		this.addressofProperty = addressofProperty;
	}

	public String getZonalClassification() {
		return zonalClassification;
	}

	public void setZonalClassification(String zonalClassification) {
		this.zonalClassification = zonalClassification;
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

	public Integer getBuildingConstructedYear() {
		return buildingConstructedYear;
	}

	public void setBuildingConstructedYear(Integer buildingConstructedYear) {
		this.buildingConstructedYear = buildingConstructedYear;
	}

	public Integer getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(Integer builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	public float getTotalTaxPayable() {
		return totalTaxPayable;
	}

	public void setTotalTaxPayable(float totalTaxPayable) {
		this.totalTaxPayable = totalTaxPayable;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

}
