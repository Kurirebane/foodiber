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
    MealPlan mealPlan = mealPlanService.getCurrentMealPlan();
    if (mealPlan == null) {
        mealPlan = new MealPlan(); // Create a new meal plan if none exists
    }
    model.addAttribute("mealPlan", mealPlan);

    // Fetch all recipes
    List<Recipe> allRecipes = recipeService.getAllRecipes();
    model.addAttribute("recipes", allRecipes);

    return "meal-plan";
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
    @GetMapping("/meal-plan/remove-recipe-from-day/{dayIndex}/{recipeId}")
    public String removeRecipeFromDay(@PathVariable int dayIndex, @PathVariable Long recipeId) {
        try {
            mealPlanService.removeRecipeFromDay(dayIndex, recipeId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Redirect to an error page or show an error message
        }
        return "redirect:/meal-plan"; // Redirect back to the meal plan page
    }


//    @GetMapping("/meal-plan/day/{dayNumber}")
//    public String getMealPlanForDay(@PathVariable int dayNumber, Model model) {
//        List<Recipe> recipes = mealPlanService.getRecipesForDay(dayNumber);
//        model.addAttribute("recipes", recipes);
//        model.addAttribute("dayNumber", dayNumber);
//        return "dayMealPlanView";
//    }
}

