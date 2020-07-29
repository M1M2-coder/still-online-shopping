package com.m2m.shoppingbackend.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.shoppingbackend.dao.CategoryDAO;
import com.m2m.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImp implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Retrieving all the active categories.
	 * */
	public List<Category> list() {
		String activeCategoryString = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(activeCategoryString);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/*
	 * Getting a specific category by it's id. 
	 * */
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	/*
	 * Adding a new category.
	 * */
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
	}

	/*
	 * Update an existing category.
	 * */
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * Delete a category..by setting active field to false.
	 * */
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
