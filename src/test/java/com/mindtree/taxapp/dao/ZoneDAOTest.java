package com.mindtree.taxapp.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.taxapp.model.Zone;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
@Transactional
public class ZoneDAOTest {
	
	@Autowired
	ZoneDAO zoneDAO;
	
	@Test
	public void getZonesTest() {
		
		List<Zone> list = zoneDAO.getZones();
		for (Zone z : list) {
			System.out.println(z.getName());
		}
		
	}

}
