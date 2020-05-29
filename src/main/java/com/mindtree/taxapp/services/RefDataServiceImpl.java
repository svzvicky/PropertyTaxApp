package com.mindtree.taxapp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.taxapp.dao.CategoryDAO;

@Service
public class RefDataServiceImpl implements RefDataService {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	@Transactional
	public boolean addCategories() {
		return categoryDAO.addCategories();
	}

	
	
}
