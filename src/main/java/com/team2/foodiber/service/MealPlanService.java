package com.team2.foodiber.service;

import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository mealPlanRepository;

    public MealPlan get3DayMealPlan() {
        // Fetch or generate a 3-day meal plan
        return mealPlanRepository.find3DayMealPlan();
    }

//    public List<Recipe> getRecipesForDay(int dayNumber) {
//        // Fetch recipes for a specific day
//        return mealPlanRepository.findRecipesByDay(dayNumber);
//    }
}
