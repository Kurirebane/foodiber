package com.team2.foodiber.controller;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

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
}
