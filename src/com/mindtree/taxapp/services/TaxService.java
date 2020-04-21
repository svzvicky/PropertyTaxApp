package com.mindtree.taxapp.services;

import java.util.List;

import com.mindtree.taxapp.model.Report;
import com.mindtree.taxapp.model.TaxAssessment;

public interface TaxService {
	
	public boolean saveTaxFiling(TaxAssessment taxAssessmnet);
	
	//public double tax(TaxAssessment taxAssessment);

	public double taxCalculation(String zone, int category, String status, int year, float buildingArea);
	
	public List<Report> zonalReport();

}
