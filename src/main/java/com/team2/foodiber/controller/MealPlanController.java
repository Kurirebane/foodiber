package com.team2.foodiber.controller;

import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.service.MealPlanService;
import com.team2.foodiber.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MealPlanController {

    @Autowired
    private MealPlanService mealPlanService;
    @Autowired private RecipeService recipeService;

//    @GetMapping("/meal-plan")
//    public String get3DayMealPlan(Model model) {
//        MealPlan mealPlan = mealPlanService.get3DayMealPlan();
//        model.addAttribute("mealPlan", mealPlan);
//        return "meal-plan";
//    }
@GetMapping("/meal-plan")
public String showMealPlan(Model model) {
    MealPlan mealPlan = mealPlanService.getCurrentMealPlan(); // Fetch a single meal plan
    model.addAttribute("mealPlan", mealPlan); // Add the meal plan to the model
    return "meal-plan"; // Return the view name
}

    @GetMapping("/meal-plan/add-recipe/{recipeId}")
    public String addRecipeToMealPlan(@PathVariable Long recipeId, Model model) {
        Recipe selectedRecipe = recipeService.getRecipeById(recipeId); // Fetch the selected recipe
        model.addAttribute("selectedRecipeId", selectedRecipe.getId());
        model.addAttribute("mealPlan", mealPlanService.getCurrentMealPlan());
        return "meal-plan";
    }

    @GetMapping("/meal-plan/add-recipe-to-day/{dayIndex}/{recipeId}")
    public String addRecipeToDay(@PathVariable int dayIndex, @PathVariable Long recipeId) {
        mealPlanService.addRecipeToDay(dayIndex, recipeId);
        return "redirect:/meal-plan";
    }


//    @GetMapping("/meal-plan/day/{dayNumber}")
//    public String getMealPlanForDay(@PathVariable int dayNumber, Model model) {
//        List<Recipe> recipes = mealPlanService.getRecipesForDay(dayNumber);
//        model.addAttribute("recipes", recipes);
//        model.addAttribute("dayNumber", dayNumber);
//        return "dayMealPlanView";
//    }
}

