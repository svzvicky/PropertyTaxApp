package com.mindtree.taxapp.dao;

import java.util.List;

import com.mindtree.taxapp.entity.TaxAssessmentEntity;
import com.mindtree.taxapp.model.Report;
import com.mindtree.taxapp.model.TaxAssessment;

public interface TaxDAO {
	
	public boolean saveTaxFiling(TaxAssessment taxAssessmnet);
	
	public float getUnitAreaValue(String zone, int category, String status);

	public List<Report> zonalReport();
	
	public List<TaxAssessmentEntity> newZonalRewport();

	List<Report> zonalReport_testImpl();

}
