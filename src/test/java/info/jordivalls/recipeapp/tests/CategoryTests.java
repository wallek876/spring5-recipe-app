package info.jordivalls.recipeapp.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import info.jordivalls.recipeapp.domain.Category;

public class CategoryTests {
	
	Category category;

	@Before
	public void setUp() throws Exception {
		category = new Category();
	}

	@Test
	public void testGetId() {
		
		Long idValue = 4L;
		
		category.setId(idValue);
		
		assertEquals(idValue, category.getId());
		
	}

	@Test
	public void testGetDescription() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGetRecipes() {
		// fail("Not yet implemented");
	}

}
