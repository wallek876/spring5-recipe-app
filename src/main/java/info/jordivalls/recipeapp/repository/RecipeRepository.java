package info.jordivalls.recipeapp.repository;

import org.springframework.data.repository.CrudRepository;

import info.jordivalls.recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
