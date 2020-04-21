package com.mindtree.taxapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.taxapp.entity.CategoryEntity;
import com.mindtree.taxapp.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getCategoryDesc() {
		List<Category> list = new ArrayList<Category>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<CategoryEntity> query = session.createQuery("From CategoryEntity", CategoryEntity.class);
			List<CategoryEntity> categories = query.getResultList();
			for(int i=0; i <categories.size(); i++) {
				CategoryEntity categoryEntity = (CategoryEntity) categories.get(i);
				Category category = new Category();
				category.setId(categoryEntity.getCat_id());
				category.setName(categoryEntity.getDescname());
				list.add(category);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> list = new ArrayList<Category>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<CategoryEntity> query = session.createQuery("From CategoryEntity", CategoryEntity.class);
			List<CategoryEntity> categories = query.getResultList();

			for(int i=0; i<categories.size(); i++) {
				CategoryEntity categoryEntity = (CategoryEntity) categories.get(i);
				Category category = new Category();
				category.setId(categoryEntity.getCat_id());
				category.setName(categoryEntity.getDescname());
				list.add(category);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

}
