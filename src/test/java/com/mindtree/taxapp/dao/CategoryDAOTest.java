package com.mindtree.taxapp.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.entity.CategoryEntity;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
public class CategoryDAOTest {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Test
	@Transactional
	public void getCategoryTest() {
		
		List<CategoryEntity> categoryEntityList = categoryDAO.getCategory();
		
		for (CategoryEntity c : categoryEntityList) {
			System.out.println(c.getDescname());
		}

	}

}
