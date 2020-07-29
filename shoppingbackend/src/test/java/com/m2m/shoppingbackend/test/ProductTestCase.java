package com.m2m.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.m2m.shoppingbackend.dao.ProductDAO;
import com.m2m.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.m2m.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCrudProduct() {
		product = new Product();
		
		product.setName("Nokia 3D N9");
		product.setBrand("NOKIA");
		product.setDescription("This is some descriptions for Nokia mobile phones!");
		product.setUnitPrice(37000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		// Test ADD new product
		//assertEquals("Something went wrong while inserting new product",true,productDAO.add(product));
		
		// Test GET single product by it's id.
		//product = productDAO.get(2);
		
		//assertEquals("Something went wrong while fetching this product","Samsung Galaxy S7",product.getName());
		
		// Test UPDATE an existing product.
		
		//product.setName("Samsung S7");
		//assertEquals("Something went wrong while updating product",true,productDAO.update(product));
		
		
		// Test RETRIEVE all products.
		//assertEquals("Something went wrong while retreiving products",7,productDAO.list().size());
		
		
		//Test DELETE a product
		//assertEquals("Something went wrong while deleting product",true,productDAO.delete(product));
	}
	
	@Test
	public void testRetrieveAllActiveProducts() {
		assertEquals("Something went wrong while retreiving active products",6,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testRetrieveAllActiveProductsByCategory() {
		
		assertEquals("Something went wrong while retreiving active products by category",4,productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void getLatestActiveProducts() {
		
		assertEquals("Something went wrong while retreiving latest active products",3,productDAO.getLatestActiveProducts(3).size());
	}
}
