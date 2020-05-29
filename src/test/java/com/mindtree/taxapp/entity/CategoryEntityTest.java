package com.mindtree.taxapp.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
public class CategoryEntityTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void insertCategories() {
		CategoryEntity categoryEntity = new CategoryEntity();
		
		categoryEntity.setCat_id(1);
		categoryEntity.setDescname("RCC buildings");
		
		categoryEntity.setCat_id(2);
		categoryEntity.setDescname("RCC buildings with cement or red-oxide flooring");
		
		categoryEntity.setCat_id(3);
		categoryEntity.setDescname("Tiled/Sheet of all kinds");
		
		Session session = sessionFactory.openSession();
		session.save(categoryEntity);
	}

}
