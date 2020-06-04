package com.mindtree.taxapp.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.model.Category;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
@Transactional
public class CategoryServiceTest {
	
	@Autowired
	CategoryService categoryService;
	
	@Test
	public void getCategoryTest() {
		List<Category> testList = categoryService.getCategory();
		
		String testString ="";
		for (int i=0; i<=0; i++) {
			testString = testList.get(0).getName();	
		}

		Assertions.assertEquals("RCC buildings1", testString);
	}

}
