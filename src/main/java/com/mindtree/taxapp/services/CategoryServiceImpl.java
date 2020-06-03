package com.mindtree.taxapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.dao.CategoryDAO;
import com.mindtree.taxapp.entity.CategoryEntity;
import com.mindtree.taxapp.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDAO;

	@Override
	@Transactional
	public List<Category> getCategory() {

		List<CategoryEntity> entityList = categoryDAO.getCategory();
		List<Category> categoryList = new ArrayList<>();

		for (CategoryEntity c : entityList) {
			Category category = new Category();
			category.setId(c.getCat_id());
			category.setName(c.getDescname());
			categoryList.add(category);
		}

		return categoryList;

	}
}
