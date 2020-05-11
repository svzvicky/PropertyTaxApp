package com.mindtree.taxapp.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.model.TaxAssessment;
import com.mindtree.taxapp.services.TaxService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
@Transactional
public class SampleTest {
	
	@Test
	void testRun() {
		
	}
	
	@Autowired
	TaxService taxService;

	@Test
	public void saveTaxFilingTest() {

		// setting the data
		TaxAssessment taxAssessment = new TaxAssessment();
		taxAssessment.setYearofAssessment(2020);
		taxAssessment.setNameofOwner("Junit Test");
		taxAssessment.setOwnerEmail("Junit@test.org");
		taxAssessment.setAddressofProperty("Junit Test Address");
		taxAssessment.setZonalClassification("B");
		taxAssessment.setPropertyDescription("");
		taxAssessment.setStatus("Owner");
		taxAssessment.setBuildingConstructedYear(2021);
		taxAssessment.setBuiltUpArea(200);
		taxAssessment.setTotalTaxPayable(202);

		// Calling the method@test boolean result =
		boolean result = taxService.saveTaxFiling(taxAssessment);

		// Verify the result
		Assertions.assertEquals(true, result, "The Data is Saved");
	}
	
	@Test
	public void taxCalculationTest() {

		// Set the Test Data
		String zone = "B";
		int category = 3;
		String status = "Owner";
		int year = 2005;
		float buildingArea = 100;

		// Call the Test Method
		double testTotalTax = taxService.taxCalculation(zone, category, status, year, buildingArea);

		// Verify the output
		Assertions.assertEquals(247.9627939453125, testTotalTax);

	}

}
