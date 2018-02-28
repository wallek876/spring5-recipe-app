package info.jordivalls.recipeapp.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import info.jordivalls.recipeapp.controller.IndexController;
import info.jordivalls.recipeapp.domain.Recipe;
import info.jordivalls.recipeapp.service.RecipeService;

public class IndexControllerTests {

	@Mock
	private RecipeService recipeService;
	
	@Mock
	private Model model;
	
	IndexController indexcontroller;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		indexcontroller = new IndexController(recipeService);
		
	}
	
	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexcontroller).build();
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}

	@Test
	public void testShowIndex() {
		
		Set<Recipe> recipesData = new HashSet<>();
		Recipe fakeRecipe1 = new Recipe();
		Recipe fakeRecipe2 = new Recipe();
		fakeRecipe1.setId(44L);
		fakeRecipe2.setId(45L);
		recipesData.add(fakeRecipe1);
		recipesData.add(fakeRecipe2);
		
		when(recipeService.getRecipes()).thenReturn(recipesData);
		
		@SuppressWarnings("unchecked")
		ArgumentCaptor<Set<Recipe>> setCaptor = ArgumentCaptor.forClass(Set.class);
		ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
		
		String viewName = indexcontroller.showIndex(model);
		
		assertEquals("index", viewName);
				
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(stringCaptor.capture(), setCaptor.capture());
		
		assertEquals(2, setCaptor.getValue().size());
		assertEquals("recipes", stringCaptor.getValue());
		
	}

}
