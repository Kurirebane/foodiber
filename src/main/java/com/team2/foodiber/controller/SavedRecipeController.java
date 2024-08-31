package com.team2.foodiber.controller;

import com.team2.foodiber.model.SavedRecipe;
import com.team2.foodiber.repository.SavedRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class SavedRecipeController {

    @Autowired
    private SavedRecipeRepository savedRecipeRepository;

    @PostMapping("/save-recipe")
    public ResponseEntity<?> saveRecipe(@RequestBody Map<String, String> request) {
        String recipeName = request.get("name");
        Long recipeId = Long.valueOf(request.get("recipeId")); // Assuming recipeId is passed in the request

        if (recipeName != null && !recipeName.isEmpty() && recipeId != null) {
            SavedRecipe savedRecipe = new SavedRecipe();
            savedRecipe.setName(recipeName);
            savedRecipe.setRecipeId(recipeId);
            savedRecipeRepository.save(savedRecipe);
            return ResponseEntity.ok(Collections.singletonMap("success", true));
        } else {
            return ResponseEntity.ok(Collections.singletonMap("success", false));
        }
    }

    @GetMapping("/saved-recipes")
    public String getSavedRecipes(Model model) {
        List<SavedRecipe> savedRecipes = savedRecipeRepository.findAll();
        if (savedRecipes.isEmpty()) {
            System.out.println("No saved recipes found");
        } else {
            for (SavedRecipe savedRecipe : savedRecipes) {
                System.out.println(savedRecipe + savedRecipe.getName());
            }
        }
        model.addAttribute("savedRecipes", savedRecipes);
        return "saved-recipes";
    }
}
