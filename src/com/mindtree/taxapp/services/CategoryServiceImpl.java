package com.mindtree.taxapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.dao.CategoryDAO;
import com.mindtree.taxapp.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public List<Category> getCategories(){
		return categoryDAO.getCategories();
		
	}
}
