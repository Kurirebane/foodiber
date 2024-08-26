package com.team2.foodiber.controller;

import com.team2.foodiber.model.SavedRecipe;
import com.team2.foodiber.repository.SavedRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SavedRecipeController {

    @Autowired
    private SavedRecipeRepository savedRecipeRepository;

    @GetMapping("/saved-recipes")
    public String getSavedRecipes(Model model) {
        List<SavedRecipe> savedRecipes = savedRecipeRepository.findAll();
        model.addAttribute("savedRecipes", savedRecipes);
        return "saved-recipes";  // The view name for saved recipes
    }
}
