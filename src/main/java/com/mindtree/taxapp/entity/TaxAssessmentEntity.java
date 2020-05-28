package com.mindtree.taxapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="taxassessment")
public class TaxAssessmentEntity {
	
	@Id
	@Column(name="AssesmentID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int AssessmentID;

	@Column(name="AssessmentYear",nullable = false, length = 5)
	private int AssessmentYear;
	
	@Column(name="OwnerName")
	private String ownerName;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="PropertyAddress")
	private String propertyAddress;
	
	@ManyToOne
	@JoinColumn(name="Zone_FK",foreignKey = @ForeignKey(name="ZoneName"))
	private ZoneEntity zoneEntity;
	
	@Column(name="FK_ZoneName")
	private String zone;
	
	@ManyToOne
	@JoinColumn(name="PropertyCategoryID",foreignKey = @ForeignKey(name="CategoryID"))
	private CategoryEntity category;
	
	@Column(name="FK_CategoryID")
	private String propertyDescription;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="BuildingConstructedYear")
	private int buildingConstructedYear;
	
	@Column(name="BuildingArea")
	private int buildingArea;
	
	@Column(name="TotalTax")
	private float totalTax;
	
	@Column(name="CreatedDateTime")
	private LocalDateTime createdateTime;
	
	public LocalDateTime getCreatedateTime() {
		return createdateTime;
	}

	public void setCreatedateTime(LocalDateTime localDateTime) {
		this.createdateTime = localDateTime;
	}

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

	public ZoneEntity getZoneEntity() {
		return zoneEntity;
	}

	public void setZoneEntity(ZoneEntity zoneEntity) {
		this.zoneEntity = zoneEntity;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
