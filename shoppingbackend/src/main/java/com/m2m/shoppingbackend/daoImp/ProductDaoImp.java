package com.m2m.shoppingbackend.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.shoppingbackend.dao.ProductDAO;
import com.m2m.shoppingbackend.dto.Product;


@Repository("productDAO")
@Transactional
public class ProductDaoImp implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Get single product by it's id.
	 * */
	public Product get(int productId) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(productId));
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Get all active and non-active products.
	 * */
	public List<Product> list() {
		return sessionFactory
					.getCurrentSession()
						.createQuery("FROM Product",Product.class)
							.getResultList();
	}

	/*
	 * Add a new product.
	 * */
	public boolean add(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Update an existing product.
	 * */
	public boolean update(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(product);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Delete a specific product.
	 * */
	public boolean delete(Product product) {
		
		try {
			product.setActive(false);
			return this.update(product);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Get All Active Products.
	 * */
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProducts,Product.class)
							.setParameter("active", true)
								.getResultList();
	}

	/*
	 * Get All Active Products by Category.
	 * */
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProductsByCategory,Product.class)
							.setParameter("active", true)
								.setParameter("categoryId", categoryId)
									.getResultList();
	
	}

	/*
	 * Get Latest Active Products with the number specified by the user.
	 * */
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	
	}

}
