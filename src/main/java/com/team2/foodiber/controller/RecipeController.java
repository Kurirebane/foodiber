package com.team2.foodiber.controller;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeIngredientsRepository recipeIngredientsRepository;

    @GetMapping("/create")
    public String showCreateRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeDto());
        return "create-recipe";
    }

    @PostMapping
    public String createRecipe(RecipeDto recipeDto, Model model) {
        RecipeDto savedRecipe = recipeService.createRecipe(recipeDto);
        model.addAttribute("recipe", savedRecipe);
        return "redirect:/recipes/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @PostMapping("/saveIngredients")
    public String saveIngredients(@RequestParam Map<String, String> params, @RequestParam("recipeId") Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));

        // Retrieve all RecipeIngredients for the recipe
        List<RecipeIngredients> recipeIngredients = recipeIngredientsRepository.findByRecipe(recipe);

        // Iterate over the form parameters and update the 'checked' status
        for (RecipeIngredients ri : recipeIngredients) {
            String paramName = "ingredient_" + ri.getId();
            boolean isChecked = params.containsKey(paramName);
            ri.setChecked(isChecked); // Assuming you have a method to set the checked status
            recipeIngredientsRepository.save(ri);
        }

        return "redirect:/recipe-details?recipeId=" + recipeId;
    }
}
