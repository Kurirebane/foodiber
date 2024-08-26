package com.team2.foodiber.service;

import com.team2.foodiber.exceptions.RecipeNotFoundException;
import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.MealPlanDay;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.repository.MealPlanDayRepository;
import com.team2.foodiber.repository.MealPlanRepository;
import com.team2.foodiber.repository.RecipeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository mealPlanRepository;
    @Autowired
    private MealPlanDayRepository mealPlanDayRepository;

    @Autowired
    private RecipeRepository recipeRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public MealPlan getCurrentMealPlan() {
        MealPlan mealPlan = mealPlanRepository.findAll().stream().findFirst().orElse(new MealPlan());
        if (mealPlan.getDays() == null || mealPlan.getDays().isEmpty()) {
            mealPlan.setDays(new ArrayList<>());
            for (int i = 0; i < 3; i++) {
                MealPlanDay day = new MealPlanDay();
                day.setRecipes(new ArrayList<>());
                mealPlan.getDays().add(day);
            }
        }
        return mealPlan;
    }

    @Transactional
    public void addRecipeToDay(int dayIndex, Long recipeId) {
        MealPlan mealPlan = getCurrentMealPlan();
        MealPlanDay day = mealPlan.getDays().get(dayIndex);

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        if (!day.getRecipes().contains(recipe)) {
            day.getRecipes().add(recipe);
            mealPlanRepository.save(mealPlan);
            entityManager.flush();
        }
    }

    @Transactional
    public void removeRecipeFromDay(int dayIndex, Long recipeId) {
        MealPlan mealPlan = getCurrentMealPlan(); // Fetch the current meal plan
        MealPlanDay day = mealPlan.getDays().get(dayIndex);

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        if (day.getRecipes().contains(recipe)) {
            day.getRecipes().remove(recipe);
            mealPlanRepository.save(mealPlan); // Save changes
        }
    }
//@Transactional
//    public void addRecipeToDay(int dayIndex, Long recipeId) {
//        MealPlan mealPlan = getCurrentMealPlan();
//        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
//
//        // Ensure the dayIndex is valid
//        while (mealPlan.getDays().size() <= dayIndex) {
//            mealPlan.getDays().add(new MealPlanDay());
//        }
//
//        MealPlanDay day = mealPlan.getDays().get(dayIndex);
//
//        // Add recipe to the day
//        day.getRecipes().add(recipe);
//
//        mealPlanRepository.save(mealPlan);
//    }
//@Transactional
//    public void removeRecipeFromDay(int dayIndex, Long recipeId) {
//        MealPlan mealPlan = getCurrentMealPlan(); // Fetch the current meal plan
//        if (dayIndex >= mealPlan.getDays().size()) {
//            throw new IllegalArgumentException("Invalid day index: " + dayIndex);
//        }
//        MealPlanDay day = mealPlan.getDays().get(dayIndex);
//
//        Recipe recipeToRemove = day.getRecipes().stream()
//                .filter(recipe -> recipe.getId().equals(recipeId))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Recipe not found in the day"));
//
//        day.getRecipes().remove(recipeToRemove);
//        mealPlanDayRepository.save(day); // Save changes to the meal plan day
//    }

} //*******************************************************************************************************


//    public void addRecipeToDay(int dayIndex, Long recipeId) {
//        MealPlan mealPlan = getCurrentMealPlan();
//        Recipe recipe = recipeRepository.findById(recipeId)
//                .orElseThrow(() -> new RuntimeException("Recipe not found"));
//
//        // Ensure enough days exist
//        while (mealPlan.getDays().size() <= dayIndex) {
//            mealPlan.getDays().add(new MealPlanDay());
//        }
//
//        MealPlanDay day = mealPlan.getDays().get(dayIndex);
//
//        // Initialize recipes list if null
//        if (day.getRecipes() == null) {
//            day.setRecipes(new ArrayList<>());
//        }
//
//        // Check if recipe is already added
//        if (day.getRecipes().contains(recipe)) {
//            throw new RuntimeException("Recipe already added to this day.");
//        }
//
//        day.getRecipes().add(recipe);
//        mealPlanRepository.save(mealPlan);
//    }