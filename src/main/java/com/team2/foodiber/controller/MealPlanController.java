package com.team2.foodiber.controller;

import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.service.MealPlanService;
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

    @GetMapping("/meal-plan")
    public String get3DayMealPlan(Model model) {
        MealPlan mealPlan = mealPlanService.get3DayMealPlan();
        model.addAttribute("mealPlan", mealPlan);
        return "meal-plan";
    }

//    @GetMapping("/meal-plan/day/{dayNumber}")
//    public String getMealPlanForDay(@PathVariable int dayNumber, Model model) {
//        List<Recipe> recipes = mealPlanService.getRecipesForDay(dayNumber);
//        model.addAttribute("recipes", recipes);
//        model.addAttribute("dayNumber", dayNumber);
//        return "dayMealPlanView";
//    }
}

