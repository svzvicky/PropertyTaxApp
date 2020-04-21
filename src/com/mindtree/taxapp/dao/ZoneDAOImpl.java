package com.mindtree.taxapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.taxapp.entity.ZoneEntity;
import com.mindtree.taxapp.model.Zone;

@Repository
public class ZoneDAOImpl implements ZoneDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Zone> getZones() {
		List<Zone> list = new ArrayList<Zone>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<ZoneEntity> query = session.createQuery("From ZoneEntity", ZoneEntity.class);
			List<ZoneEntity> queryResult = query.getResultList();
			
			for (int i=0; i<queryResult.size();i++) {
				ZoneEntity zoneEntity = (ZoneEntity) queryResult.get(i);
				Zone zone = new Zone();
				zone.setId(zoneEntity.getId());
				zone.setName(zoneEntity.getName());
				list.add(zone);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
