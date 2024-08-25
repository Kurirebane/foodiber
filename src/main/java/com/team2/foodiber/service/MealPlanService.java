package com.team2.foodiber.service;

import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.MealPlanDay;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.repository.MealPlanRepository;
import com.team2.foodiber.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository mealPlanRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    public MealPlan getCurrentMealPlan() {
        MealPlan mealPlan = mealPlanRepository.findAll().stream().findFirst().orElse(new MealPlan());
        if (mealPlan.getDays() == null || mealPlan.getDays().isEmpty()) {
            mealPlan.setDays(new ArrayList<>());
            // Optionally, add initial empty days if necessary
            for (int i = 0; i < 3; i++) { // Assuming a 3-day meal plan
                MealPlanDay day = new MealPlanDay();
                day.setRecipes(new ArrayList<>());
                mealPlan.getDays().add(day);
            }
        }
        return mealPlan;
    }

    public void addRecipeToDay(int dayIndex, Long recipeId) {
        MealPlan mealPlan = getCurrentMealPlan();
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        // Ensure enough days exist
        while (mealPlan.getDays().size() <= dayIndex) {
            mealPlan.getDays().add(new MealPlanDay());
        }

        MealPlanDay day = mealPlan.getDays().get(dayIndex);

        // Initialize recipes list if null
        if (day.getRecipes() == null) {
            day.setRecipes(new ArrayList<>());
        }

        // Check if recipe is already added
        if (day.getRecipes().contains(recipe)) {
            throw new RuntimeException("Recipe already added to this day.");
        }

        day.getRecipes().add(recipe);
        mealPlanRepository.save(mealPlan);
    }

//    public List<MealPlan> getMealPlan() {
//        return mealPlanRepository.findAll();
//    }
}

