package com.mindtree.taxapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.taxapp.entity.TaxAssessmentEntity;
import com.mindtree.taxapp.model.Report;
import com.mindtree.taxapp.model.TaxAssessment;

@Repository
public class TaxDAOImpl implements TaxDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveTaxFiling(TaxAssessment taxAssessment) {

		boolean saveFlag = true;
		TaxAssessmentEntity taxAssessmentEntity = new TaxAssessmentEntity();
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
			System.out.println("\n Category Value in DAO impl" + category);

			if (zone.contains("A")) {
				hql = "Select ZoneA from UnitAreaValueEntity uav where uav.Category_id=:Category and uav.Status=:status";
			} else if (zone.contains("B")) {
				hql = "Select ZoneB from UnitAreaValueEntity uav where uav.Category_id=:Category and uav.Status=:status";
			} else if (zone.contains("C")) {
				hql = "Select Zone" + zone
						+ " from UnitAreaValueEntity uav where uav.Category_id=:Category and uav.Status=:status";
			}
			System.out.println("Fired Query =" + hql);
			Query query = session.createQuery(hql);
			query.setParameter("Category", category);
			query.setParameter("status", status);
			List result = query.list();

			System.out.println("Result Set" + result);

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
		System.out.println("Executed Query" + hql);
		List<Object[]> result = query.getResultList();

		for (int i = 0; i < result.size(); i++) {
			Object[] row = (Object[]) result.get(i);
			Report report = new Report();
			report.setZone((String) row[0]);
			System.out.println("Report zone contents" + report.getZone());
			report.setPropertyType((String) row[1]);
			System.out.println("Report proptype contents" + report.getPropertyType());
			report.setAmountCollected(((double) row[2]));
			System.out.println("Report amount contents" + report.getAmountCollected());
			reportList.add(report);
		}

		return reportList;

	}
}
