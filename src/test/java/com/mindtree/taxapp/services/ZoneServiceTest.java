package com.mindtree.taxapp.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.dao.ZoneDAO;
import com.mindtree.taxapp.model.Zone;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
@Transactional
public class ZoneServiceTest {
	
	@Autowired
	ZoneDAO zoneDAO;
	
	@Test
	public void getZonesTest() {
		
		List<Zone> list = zoneDAO.getZones();
		String testZone ="";
		
		for (Zone z : list) {
			 testZone = z.getName();
		}
		Assertions.assertEquals("A", testZone);
	}

}
