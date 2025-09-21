package com.team2.foodiber.repository;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Long> {
    List<RecipeIngredients> findByRecipe(Recipe recipe);
}
