package com.team2.foodiber.service;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.model.*;
import com.team2.foodiber.repository.IngredientsRepository;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    public final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;
    private final RecipeIngredientsRepository recipeIngredientsRepository;


    public RecipeService(RecipeRepository recipeRepository, IngredientsRepository ingredientsRepository, RecipeIngredientsRepository recipeIngredientsRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.recipeIngredientsRepository = recipeIngredientsRepository;
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

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
    }



//    @Transactional
//    public void setupRecipe() {
//        Recipe savedPumpkinSoup = recipeRepository.findById(1L).orElseThrow();
//
//        Ingredient savedIngredientsCarrot = ingredientsRepository.findById(1L).orElseThrow();
//        Ingredient ingredientOliveOil = ingredientsRepository.findById(2L).orElseThrow();
//
//        RecipeIngredients recipeIngredientsCarrot = new RecipeIngredients();
//        recipeIngredientsCarrot.setIngredient(savedIngredientsCarrot);
//        recipeIngredientsCarrot.setRecipe(savedPumpkinSoup);
//        recipeIngredientsCarrot.setQuantityPerServing("3");
//        recipeIngredientsRepository.save(recipeIngredientsCarrot);
//
//        RecipeIngredients recipeIngredientsOliveOil = new RecipeIngredients();
//        recipeIngredientsOliveOil.setIngredient(ingredientOliveOil);
//        recipeIngredientsOliveOil.setRecipe(savedPumpkinSoup);
//        recipeIngredientsOliveOil.setQuantityPerServing("3 tablespoons");
//        recipeIngredientsRepository.save(recipeIngredientsOliveOil);
//
//        savedPumpkinSoup.getIngredients().add(recipeIngredientsCarrot);
//        savedPumpkinSoup.getIngredients().add(recipeIngredientsOliveOil);
//        recipeRepository.save(savedPumpkinSoup);
//    }







//    public void addIngredientToRecipe(Recipe recipe, String ingredientName, String quantityPerServing) {
//
//        Ingredient ingredient = ingredientsRepository.findByName(ingredientName)
//                .orElseGet(() -> {
//                    Ingredient newIngredient = new Ingredient();
//                    newIngredient.setItem(ingredientName);
//                    newIngredient.setGlutenFree(true);
//                    newIngredient.setLactoseFree(true);
//                    return ingredientsRepository.save(newIngredient);
//                });
//
//        // Create RecipeIngredients object
//        RecipeIngredients recipeIngredient = new RecipeIngredients();
//        recipeIngredient.setIngredient(ingredient);
//        recipeIngredient.setRecipe(recipe);
//        recipeIngredient.setQuantityPerServing(quantityPerServing);
//
//        // Add to Recipe's ingredients list
//        recipe.getIngredients().add(recipeIngredient);
//
//        // Save the Recipe and RecipeIngredients
//        recipeIngredientsRepository.save(recipeIngredient);
//        recipeRepository.save(recipe);
//    }
}

