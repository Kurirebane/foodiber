package com.team2.foodiber.repository;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository <Recipe, Long> {


List <Recipe> findByRecipeCategory(RecipeCategory recipeCategory);

    Recipe findAllById(Long id);

List <Recipe> findByUserId(Long userId);  //need this to get userCreatedRecipes by userId
}