package info.jordivalls.recipeapp.service;

import java.util.Set;

import info.jordivalls.recipeapp.domain.Recipe;

public interface RecipeService {

	public Set<Recipe> getRecipes();
}
