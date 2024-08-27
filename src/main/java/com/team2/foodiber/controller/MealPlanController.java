package com.team2.foodiber.controller;
import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.service.MealPlanService;
import com.team2.foodiber.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class MealPlanController {

    @Autowired
    private MealPlanService mealPlanService;
    @Autowired
    private RecipeService recipeService;


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
        // Log the received values
        System.out.println("Received Day Index: " + dayIndex);  // This should log `0` for the first day
        System.out.println("Received Recipe ID: " + recipeId);

        try {
            mealPlanService.removeRecipeFromDay(dayIndex, recipeId);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error removing recipe from meal plan: " + e.getMessage());
            return "error";  // Redirect to an error page or show an error message
        }
        return "redirect:/meal-plan";
    }

}
