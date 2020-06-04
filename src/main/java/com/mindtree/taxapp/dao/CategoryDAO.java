package com.mindtree.taxapp.dao;

import java.util.List;

import com.mindtree.taxapp.entity.CategoryEntity;

public interface CategoryDAO {

	public List<CategoryEntity> getCategory();

	public boolean addCategories();

}
