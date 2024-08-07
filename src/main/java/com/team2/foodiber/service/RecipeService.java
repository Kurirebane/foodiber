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

    private Recipe recipeDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setRecipeCategory(RecipeCategory.valueOf(recipeDto.getCategory()));
        recipe.setCookingTime(recipeDto.getCookingTime());
        return recipe;
    }

    private RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setCategory(String.valueOf(RecipeCategory.valueOf(recipeDto.getCategory())));
        recipeDto.setCookingTime(recipeDto.getCookingTime());
        return recipeDto;
    }

    public RecipeDto createRecipe(RecipeDto createdRecipeDto) {
        Recipe recipe = recipeDtoToRecipe(new RecipeDto());
        Recipe savedRecipe = recipeRepository.save(recipe);
        return toDto(savedRecipe);
    }

    public List<Recipe> getRecipesByCategory(RecipeCategory category) {
        return recipeRepository.findByRecipeCategory(category);
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();

    }

}

