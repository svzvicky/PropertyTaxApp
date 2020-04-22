package com.mindtree.taxapp.services;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.dao.TaxDAO;
import com.mindtree.taxapp.model.Report;
import com.mindtree.taxapp.model.TaxAssessment;

@Service
public class TaxServiceImpl implements TaxService {
	
	private static final Logger logger = Logger.getLogger(TaxServiceImpl.class);

	@Autowired
	TaxDAO taxAssessmentDAO;

	@Override
	@Transactional
	public boolean saveTaxFiling(TaxAssessment taxAssessmnet) {
		return taxAssessmentDAO.saveTaxFiling(taxAssessmnet);
	}

/*	@Override
	@Transactional
	public double tax(TaxAssessment taxAssessment) {

		//float UAV = taxAssessmentDAO.getUnitAreaValue(taxAssessment.getPropertyDescription(),taxAssessment.getZonalClassification(),taxAssessment.getStatus());
		float Total_1 = taxAssessment.getBuiltUpArea() * UAV * 10;

		// Calculating the Age of the Building
		int buildingAge = taxAssessment.getBuildingConstructedYear() - Calendar.getInstance().get(Calendar.YEAR);
		double depreciation;
		if (buildingAge < 60) {
			depreciation = buildingAge / 100;
		} else {
			depreciation = 0.6;
		}

		double Total_2 = Total_1 - depreciation;
		double Total_3 = Total_2 * 0.2;
		double Total_4 = Total_3 * 0.24;
		double totalTax = Total_3 + Total_4;

		return totalTax;
	}*/

	@Override
	@Transactional
	public double taxCalculation(String zone, int category, String status, int year, float buildingArea) {
		
		logger.info("Begining Tax Calculation...!");
		logger.debug("Received Values => Zone:" + zone+ "+++Category:" + category + "+++status:" + status  + "+++ Builiding Constructed Year:"+ year +"+++ Area of the buidling:"+buildingArea);
		
		float UAV = taxAssessmentDAO.getUnitAreaValue(zone,category,status);
		logger.debug("UAV Value ="+ UAV);
		
		//Calculating the Total 1
		float Total_1 = buildingArea * UAV * 10;
		logger.debug("Total 1 Calculated["+Total_1+"]="+ "buildingArea["+ buildingArea + "] * unit area Value[" + UAV +"] * 10");
		
		// Calculating the Age of the Building
		float buildingAge = 0;
		if(year > 0) {
			buildingAge = Calendar.getInstance().get(Calendar.YEAR)- year;
			logger.debug("Age of the building:[ "+ buildingAge + "] = Current Year:[" + Calendar.getInstance().get(Calendar.YEAR) + "]- Builiding Constructed Year:["+year + "]");
		}
		
		//Calculating the depreciation
		float depreciation;
		if (buildingAge < 60) {
			depreciation = (buildingAge/100);
			logger.debug("depreciation1:"+ depreciation);
		} else {
			depreciation = (float) 0.6;
			logger.debug("depreciation2:"+ depreciation);
		}
		
		//Calculating the Total 2
		double Total_2 = (Total_1 - depreciation);
		logger.debug("Total_2["+Total_2+"]=Total_1["+Total_1+"] - depreciation["+depreciation+"]");
		
		double Total_3 = Total_2 * 0.2;
		logger.debug("Total_3="+Total_3);
		double Total_4 = Total_3 * 0.24;
		logger.debug("Total_4="+Total_4);
		double totalTax = Total_3 + Total_4;
		logger.debug("totalTax="+totalTax);
		
		return totalTax;
	}

	@Override
	@Transactional
	public List<Report> zonalReport() {
		// TODO Auto-generated method stub
		return taxAssessmentDAO.zonalReport();
	}

}
