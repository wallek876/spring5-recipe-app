package info.jordivalls.recipeapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import info.jordivalls.recipeapp.domain.Category;
import info.jordivalls.recipeapp.domain.UnitOfMeasure;
import info.jordivalls.recipeapp.repository.CategoryRepository;
import info.jordivalls.recipeapp.repository.UnitOfMeasureRepository;
import info.jordivalls.recipeapp.service.RecipeService;

@Controller
public class IndexController {
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping({"", "/", "index"})
	public String showIndex(Model model) {
		
		model.addAttribute("recipes", this.recipeService.getRecipes());
		
		return "index";
	}
}
