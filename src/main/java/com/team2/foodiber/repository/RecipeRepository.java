package com.team2.foodiber.repository;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByRecipeCategory(RecipeCategory recipeCategory);

    Optional<Recipe> findById(Long id);

    List<Recipe> findByUserId(Long userId);
}