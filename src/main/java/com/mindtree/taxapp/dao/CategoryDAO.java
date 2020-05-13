package com.mindtree.taxapp.dao;

import java.util.List;

import com.mindtree.taxapp.model.Category;

public interface CategoryDAO {

	public List<Category> getCategoryDesc();

	public List<Category> getCategories();
}
