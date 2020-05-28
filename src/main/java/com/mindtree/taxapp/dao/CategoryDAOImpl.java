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
			for (int i = 0; i < categories.size(); i++) {
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

			for (int i = 0; i < categories.size(); i++) {
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
			saveFlag=true;
		}

		return saveFlag;
	}
}
