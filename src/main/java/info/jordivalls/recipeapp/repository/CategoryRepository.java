package info.jordivalls.recipeapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import info.jordivalls.recipeapp.domain.Category;



public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category> findByDescription(String description);

}
