package com.mindtree.taxapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Zones")
public class ZoneEntity {
	
	@Column(name="ZoneID")
	private int id;
	
	@Id
	@Column(name="ZoneName")
	private String zoneName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return zoneName;
	}

	public void setName(String name) {
		this.zoneName = name;
	}

}
