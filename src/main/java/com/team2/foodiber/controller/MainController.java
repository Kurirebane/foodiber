package com.team2.foodiber.controller;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import com.team2.foodiber.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping()
    public String getIndex(){
        return "index";
    }

    @GetMapping(path = "/select-category")
    public String getAllCategories(){

        return "select-category";
    }


    @GetMapping("/category")
    public String getCategoryPage(@RequestParam(name = "name") RecipeCategory recipeCategory, ModelMap model) {
        List<Recipe> filteredRecipes = recipeService.getRecipesByCategory(recipeCategory);
        model.addAttribute("recipes", filteredRecipes);
        model.addAttribute("categoryName", recipeCategory);
        return "category";
    }

    @GetMapping("/recipe/details")
    public String getRecipeDetails(@RequestParam(name = "id") Long recipeId, Model model) {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipe-details";  // The template to display the recipe details
    }





//    @GetMapping(path = )






}
