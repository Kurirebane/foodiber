package com.team2.foodiber.repository;

import com.team2.foodiber.model.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository <RecipeIngredients, Long> {
}
