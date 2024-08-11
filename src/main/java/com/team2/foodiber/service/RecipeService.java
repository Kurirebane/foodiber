package com.team2.foodiber.service;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.model.CookingTime;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import com.team2.foodiber.model.User;
import com.team2.foodiber.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    public final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    //RecipeDTO -> Recipe
    private Recipe recipeDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setRecipeCategory(RecipeCategory.valueOf(recipeDto.getCategory()));
        recipe.setCookingTime(recipeDto.getCookingTime());
        return recipe;
    }
    // Recipe -> RecipeDTO
    private RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setCategory(String.valueOf(RecipeCategory.valueOf(recipeDto.getCategory())));
        recipeDto.setCookingTime(recipeDto.getCookingTime());
        return recipeDto;
    }
    // New Recipe
    public RecipeDto createRecipe(RecipeDto createdRecipeDto) {
        Recipe recipe = recipeDtoToRecipe(new RecipeDto());
        Recipe savedRecipe = recipeRepository.save(recipe);
        return toDto(savedRecipe);
    }
    // get all RECIPES by Category
    public List<Recipe> getRecipesByCategory(RecipeCategory category) {
        return recipeRepository.findByRecipeCategory(category);
    }

    // get all Recipes
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();

    }
    // get Recipe by ID
    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findAllById(recipeId);
    }

    // save Recipes
    public RecipeDto saveRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeDtoToRecipe(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return toDto(savedRecipe);
    }
}

