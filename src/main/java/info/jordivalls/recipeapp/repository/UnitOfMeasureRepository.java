package info.jordivalls.recipeapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import info.jordivalls.recipeapp.domain.UnitOfMeasure;



public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
}
