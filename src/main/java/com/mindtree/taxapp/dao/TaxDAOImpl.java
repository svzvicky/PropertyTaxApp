package com.mindtree.taxapp.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.taxapp.entity.CategoryEntity;
import com.mindtree.taxapp.entity.TaxAssessmentEntity;
import com.mindtree.taxapp.entity.ZoneEntity;
import com.mindtree.taxapp.model.Report;
import com.mindtree.taxapp.model.TaxAssessment;

@Repository
public class TaxDAOImpl implements TaxDAO {
	
	private static final Logger logger = Logger.getLogger(TaxDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveTaxFiling(TaxAssessment taxAssessment) {

		boolean saveFlag = true;
		TaxAssessmentEntity taxAssessmentEntity = new TaxAssessmentEntity();
		CategoryEntity categoryEntity = new CategoryEntity();
		ZoneEntity zoneEntity = new ZoneEntity();
		
		int CategoryID = Integer.parseInt(taxAssessment.getPropertyDescription());
		categoryEntity.setCat_id(CategoryID);
		//zoneEntity.setName("D");
		zoneEntity.setName(taxAssessment.getZonalClassification());
		
		taxAssessmentEntity.setAssessmentYear(taxAssessment.getYearofAssessment());
		taxAssessmentEntity.setOwnerName(taxAssessment.getNameofOwner());
		taxAssessmentEntity.setEmail(taxAssessment.getOwnerEmail());
		taxAssessmentEntity.setPropertyAddress(taxAssessment.getAddressofProperty());
		taxAssessmentEntity.setZone(taxAssessment.getZonalClassification());
		taxAssessmentEntity.setPropertyDescription(taxAssessment.getPropertyDescription());
		taxAssessmentEntity.setStatus(taxAssessment.getStatus());
		taxAssessmentEntity.setBuildingConstructedYear(taxAssessment.getBuildingConstructedYear());
		taxAssessmentEntity.setBuildingArea(taxAssessment.getBuiltUpArea());
		taxAssessmentEntity.setTotalTax(taxAssessment.getTotalTaxPayable());
		taxAssessmentEntity.setCreatedateTime(LocalDateTime.now());
		
		//Using entities to insert the values
		taxAssessmentEntity.setCategory(categoryEntity);
		taxAssessmentEntity.setZoneEntity(zoneEntity);
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(taxAssessmentEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
			saveFlag = false;
		}

		return saveFlag;
	}

	@Override
	public float getUnitAreaValue(String zone, int category, String status) {

		float uav_value = 0;
		String hql = "";
		try {
			Session session = sessionFactory.getCurrentSession();
			logger.debug("\n Category Value in DAO impl" + category);

			if (zone.contains("A")) {
				hql = "Select ZoneA from UnitAreaValueEntity uav where uav.Category_id=:Category and uav.Status=:status";
			} else if (zone.contains("B")) {
				hql = "Select ZoneB from UnitAreaValueEntity uav where uav.Category_id=:Category and uav.Status=:status";
			} else if (zone.contains("C")) {
				hql = "Select Zone" + zone
						+ " from UnitAreaValueEntity uav where uav.Category_id=:Category and uav.Status=:status";
			}
			logger.debug("Fired Query =" + hql);
			Query query = session.createQuery(hql);
			query.setParameter("Category", category);
			query.setParameter("status", status);
			List result = query.list();

			logger.debug("Result Set" + result);

			Iterator iterator = result.iterator();

			while (iterator.hasNext()) {
				uav_value = (float) iterator.next();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("UAV Value from DB=" + uav_value);
		return uav_value;
	}

	@Override
	public List<Report> zonalReport() {

		List<Report> reportList = new ArrayList<Report>();

		// Query to retrive the data from DB
		String hql = "select zone,status,round(sum(totalTax),2) as TotalTax FROM TaxAssessmentEntity  group by zone,status order by zone";

		// Hibernate values
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		logger.debug("Executed Query" + hql);
		List<Object[]> result = query.getResultList();

		for (int i = 0; i < result.size(); i++) {
			Object[] row = (Object[]) result.get(i);
			Report report = new Report();
			report.setZone((String) row[0]);
			logger.debug("Report zone contents" + report.getZone());
			report.setPropertyType((String) row[1]);
			logger.debug("Report proptype contents" + report.getPropertyType());
			report.setAmountCollected(((double) row[2]));
			logger.debug("Report amount contents" + report.getAmountCollected());
			reportList.add(report);
		}

		return reportList;

	}
}
