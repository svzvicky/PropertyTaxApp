package com.mindtree.taxapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unitareavalue")
public class UnitAreaValueEntity {
	
	@Id
	@Column(name = "ID")
	private int Id;

	@Column(name = "category_id")
	private int Category_id;

	@Column(name = "status")
	private String Status;

	@Column(name = "A")
	private float ZoneA;

	@Column(name = "B")
	private float ZoneB;

	@Column(name = "C")
	private float ZoneC;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCategory_id() {
		return Category_id;
	}

	public void setCategory_id(int category_id) {
		Category_id = category_id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public float getZoneA() {
		return ZoneA;
	}

	public void setZoneA(float zoneA) {
		ZoneA = zoneA;
	}

	public float getZoneB() {
		return ZoneB;
	}

	public void setZoneB(float zoneB) {
		ZoneB = zoneB;
	}

	public float getZoneC() {
		return ZoneC;
	}

	public void setZoneC(float zoneC) {
		ZoneC = zoneC;
	}

}
