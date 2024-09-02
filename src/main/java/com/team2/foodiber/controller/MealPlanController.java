package com.team2.foodiber.controller;

import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.MealPlanService;
import com.team2.foodiber.service.RecipeService;
import com.team2.foodiber.service.ShoppingListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@AllArgsConstructor
public class MealPlanController {

    private MealPlanService mealPlanService;
    private RecipeService recipeService;
    private RecipeRepository recipeRepository;
    private ShoppingListService shoppingListService;


    @GetMapping("/meal-plan")
    public String showMealPlan(Model model) {
        MealPlan mealPlan = mealPlanService.getCurrentMealPlan();
        model.addAttribute("mealPlan", mealPlan);
        return "meal-plan";
    }

    @GetMapping("/meal-plan/add-recipe/{recipeId}")
    public String addRecipeToMealPlan(@PathVariable Long recipeId, Model model) {
        Recipe selectedRecipe = recipeService.getRecipeById(recipeId);
        model.addAttribute("selectedRecipeId", selectedRecipe.getId());
        model.addAttribute("mealPlan", mealPlanService.getCurrentMealPlan());
        return "meal-plan";
    }

    @GetMapping("/meal-plan/add-recipe-to-day/{dayIndex}/{recipeId}")
    public String addRecipeToDay(@PathVariable int dayIndex, @PathVariable Long recipeId) {
        mealPlanService.addRecipeToDay(dayIndex, recipeId);
        return "redirect:/meal-plan";
    }

    @PostMapping("/meal-plan/remove-recipe-from-day/{dayIndex}/{recipeId}")
    public String removeRecipeFromDay(@PathVariable int dayIndex, @PathVariable Long recipeId, Model model) {

        log.info("Received Day Index: " + dayIndex);
        log.info("Received Recipe ID: " + recipeId);

        try {
            mealPlanService.removeRecipeFromDay(dayIndex, recipeId);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error removing recipe from meal plan: " + e.getMessage());
            return "error";
        }
        return "redirect:/meal-plan";
    }

    @PostMapping("/recipes/add-to-shopping-list")
    public String addToShoppingList(@RequestParam("selectedIngredients") List<Long> ingredientIds,
                                    @RequestParam("recipeId") Long recipeId) {

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + recipeId));

        List<RecipeIngredients> selectedIngredients = recipe.getIngredients().stream()
                .filter(ingredient -> ingredientIds.contains(ingredient.getId()))
                .collect(Collectors.toList());

        shoppingListService.addIngredientsToShoppingList(selectedIngredients, 1);

        return "redirect:/meal-plan";
    }
}
