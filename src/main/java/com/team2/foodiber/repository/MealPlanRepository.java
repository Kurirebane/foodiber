package com.team2.foodiber.repository;

import com.team2.foodiber.model.MealPlan;
import com.team2.foodiber.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {
    public default MealPlan find3DayMealPlan() {
        // Fetch the 3-day meal plan from the database
        return new MealPlan(); // Replace with actual fetching logic
    }


}
