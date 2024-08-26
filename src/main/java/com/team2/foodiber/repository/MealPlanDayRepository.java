package com.team2.foodiber.repository;

import com.team2.foodiber.model.MealPlanDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanDayRepository extends JpaRepository<MealPlanDay, Long> {
}
