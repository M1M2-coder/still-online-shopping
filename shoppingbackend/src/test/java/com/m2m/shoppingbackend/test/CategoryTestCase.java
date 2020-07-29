package com.m2m.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.m2m.shoppingbackend.dao.CategoryDAO;
import com.m2m.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.m2m.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Music Box");
	 * category.setDescription("All What You Need To Know About Music Boxes");
	 * category.setImage_URL("Cat_4.png");
	 * 
	 * assertEquals("Failed To Add New Category",true,categoryDAO.add(category)); }
	 */

	/*
	 * @Test public void testGetCategoryById() { category = categoryDAO.get(1);
	 * 
	 * assertEquals("Failed To Get Category","Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(1);
	 * category.setName("TV");
	 * assertEquals("Failed To UPDATE Category",true,categoryDAO.update(category));
	 * }
	 * 
	 */
	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(1);
	 * assertEquals("Failed To DELETE Category",true,categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testRetrieveAllCategories() {
	 * assertEquals("Failed To RETRIEVE all active Categories",3,categoryDAO.list().
	 * size()); }
	 */

	@Test
	public void testCrudCategory() {
		// Add First Category
		category = new Category();

		category.setName("Music Box");
		category.setDescription("All What You Need To Know About Music Boxes");
		category.setImage_URL("Cat_1.png");

		assertEquals("Failed To Add New Category", true, categoryDAO.add(category));

		// Add Second Category.
		category = new Category();

		category.setName("Television");
		category.setDescription("All What You Need To Know About Televisions");
		category.setImage_URL("Cat_2.png");

		assertEquals("Failed To Add New Category", true, categoryDAO.add(category));

		// Add Third Category.
		category = new Category();

		category.setName("Laptop");
		category.setDescription("All What You Need To Know About Laptops");
		category.setImage_URL("Cat_3.png");

		assertEquals("Failed To Add New Category", true, categoryDAO.add(category));

		// TEST GET CATEGORY BY ID
		category = categoryDAO.get(18);

		assertEquals("Failed To Get Category", "Television", category.getName());

		// TEST Updating Category.
		category.setName("TV");
		assertEquals("Failed To UPDATE Category", true, categoryDAO.update(category));

		// TEST Deleting Category.
		assertEquals("Failed To DELETE Category", true, categoryDAO.delete(category));

		// Test Retrieving all categories.
		assertEquals("Failed To RETRIEVE all active Categories", 2, categoryDAO.list().size());

	}

}
