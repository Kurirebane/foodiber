package com.team2.foodiber.repository;

import com.team2.foodiber.model.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientsRepository extends JpaRepository <RecipeIngredients, Long> {
}
