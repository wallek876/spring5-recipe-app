package info.jordivalls.recipeapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import info.jordivalls.recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class IndexController {
	
	@Autowired
	private RecipeService recipeService;
	
	/*
	 * Constructors
	 */
	public IndexController() {	
	}
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
		log.warn("created IndexController with constructor");
	}
	
	@GetMapping({"", "/", "index"})
	public String showIndex(Model model) {
		
		model.addAttribute("recipes", this.recipeService.getRecipes());
		
		log.warn("Showing index page");
		
		return "index";
	}
}
