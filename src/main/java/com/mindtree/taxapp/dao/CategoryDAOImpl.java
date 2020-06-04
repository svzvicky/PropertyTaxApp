package com.mindtree.taxapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.taxapp.entity.CategoryEntity;
import com.mindtree.taxapp.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CategoryEntity> getCategory() {

		List<CategoryEntity> categories = sessionFactory.getCurrentSession().createQuery("From CategoryEntity", CategoryEntity.class)
				.getResultList();
		
		return categories;
	}

	// method to add the categories when the new db is created
	@Override
	public boolean addCategories() {

		boolean saveFlag = false;
		Session session = sessionFactory.getCurrentSession();

		List<Category> categoryList = new ArrayList<>();
		categoryList.add(new Category(1, "RCC buildings"));
		categoryList.add(new Category(2, "RCC buildings with cement or red-oxide flooring"));
		categoryList.add(new Category(3, "Tiled/Sheet of all kinds"));

		for (Category c : categoryList) {
			CategoryEntity categoryEntity = new CategoryEntity();
			categoryEntity.setCat_id(c.getId());
			categoryEntity.setDescname(c.getName());
			session.save(categoryEntity);
			saveFlag = true;
		}

		return saveFlag;
	}
}