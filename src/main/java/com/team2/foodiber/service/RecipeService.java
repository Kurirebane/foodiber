package com.team2.foodiber.service;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.model.CookingTime;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import com.team2.foodiber.model.User;
import com.team2.foodiber.repository.RecipeRepository;

public class RecipeService {

    public final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private Recipe RecipeDtoToRecipe (RecipeDto recipeDto){
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setRecipeCategory(RecipeCategory.valueOf(recipeDto.getCategory()));
        recipe.setCookingTime(recipeDto.getCookingTime());
        return recipe;
    }

    private RecipeDto toDto(Recipe recipe){
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setCategory(String.valueOf(recipe.getRecipeCategory()));
        recipeDto.setCookingTime(CookingTime.valueOf(String.valueOf(recipe.getRecipeCategory())));
        return recipeDto;
    }

//    public RecipeDto createRecipe(RecipeDto newRecipeDto) {
//        Recipe recipe = new RecipeDto(newRecipeDto);
//        return  toDto(recipeRepository.save(newRecipeDto));
//    } // täpselt ei tea ja ei saa nendest Dto'dest aru
}
