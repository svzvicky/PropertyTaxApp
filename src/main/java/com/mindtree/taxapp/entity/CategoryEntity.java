package com.mindtree.taxapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class CategoryEntity {
	
	@Id
	@Column(name="CategoryID")
	private Integer cat_id;
	
	@Column(name="CategoryDesc")
	private String descname;
	
	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}

	public String getDescname() {
		return descname;
	}

	public void setDescname(String descname) {
		this.descname = descname;
	}
	
	public CategoryEntity() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_id == null) ? 0 : cat_id.hashCode());
		result = prime * result + ((descname == null) ? 0 : descname.hashCode());
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
		CategoryEntity other = (CategoryEntity) obj;
		if (cat_id == null) {
			if (other.cat_id != null)
				return false;
		} else if (!cat_id.equals(other.cat_id))
			return false;
		if (descname == null) {
			if (other.descname != null)
				return false;
		} else if (!descname.equals(other.descname))
			return false;
		return true;
	}

}
