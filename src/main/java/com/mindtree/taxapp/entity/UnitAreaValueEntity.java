package com.mindtree.taxapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unitareavalue")
public class UnitAreaValueEntity {
	
	@Id
	@Column(name = "UID")
	private int Id;

	@Column(name = "FK_CategoryID")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Category_id;
		result = prime * result + Id;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + Float.floatToIntBits(ZoneA);
		result = prime * result + Float.floatToIntBits(ZoneB);
		result = prime * result + Float.floatToIntBits(ZoneC);
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
		UnitAreaValueEntity other = (UnitAreaValueEntity) obj;
		if (Category_id != other.Category_id)
			return false;
		if (Id != other.Id)
			return false;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (Float.floatToIntBits(ZoneA) != Float.floatToIntBits(other.ZoneA))
			return false;
		if (Float.floatToIntBits(ZoneB) != Float.floatToIntBits(other.ZoneB))
			return false;
		if (Float.floatToIntBits(ZoneC) != Float.floatToIntBits(other.ZoneC))
			return false;
		return true;
	}

}
