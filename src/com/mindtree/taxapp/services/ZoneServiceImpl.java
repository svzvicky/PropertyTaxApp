package com.mindtree.taxapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.taxapp.dao.ZoneDAO;
import com.mindtree.taxapp.model.Zone;

@Service
public class ZoneServiceImpl implements ZoneService {
	
	@Autowired
	ZoneDAO zoneDAO;
	
	@Override
	@Transactional
	public List<Zone> getZones() {
		return zoneDAO.getZones();
	}

}
