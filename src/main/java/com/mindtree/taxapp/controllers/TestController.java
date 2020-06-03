package com.mindtree.taxapp.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.taxapp.dao.TaxDAO;
import com.mindtree.taxapp.model.Category;
import com.mindtree.taxapp.services.CategoryService;
import com.mindtree.taxapp.services.RefDataService;

@RestController
@RequestMapping("/test")
public class TestController {

	private static final Logger logger = Logger.getLogger(TestController.class);

	@Autowired
	RefDataService refDateService;
	
	@Autowired
	TaxDAO taxDAO;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("/addCategories")
	public String addCategoriesTest() {

		String message = null;
		if (refDateService.addCategories()) {
			logger.info("Categories Added");
			message = "Categories Added";
		}
		return message;
	}
	
	@RequestMapping("/records")
	public void taxAssessmentTest() {
		//taxDAO.newZonalRewport();
		//taxDAO.zonalReport_testImpl();
		//categoryService.getCategory();
		taxDAO.getUnitAreaValue1("A", 2, "Owner");
	}
}
