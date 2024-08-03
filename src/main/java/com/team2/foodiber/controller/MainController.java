package com.team2.foodiber.controller;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    // Create an API with path /search-recipe that shows the list of recipes


    private final RecipeService recipeService;

    @GetMapping(path = "/search-recipe")
    public String getAllRecipes (final ModelMap modelMap) {
        List <Recipe> recipes = recipeService.getAllRecipes();
        modelMap.addAttribute("recipes", recipes);
        return "search-recipes";
    }




}
