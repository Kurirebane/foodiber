package com.team2.foodiber.service;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.exceptions.RecipeNotFoundException;
import com.team2.foodiber.model.*;
import com.team2.foodiber.repository.IngredientsRepository;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //RecipeDTO -> Recipe
    private Recipe recipeDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setRecipeCategory(RecipeCategory.valueOf(recipeDto.getCategory()));
        recipe.setCookingTime(recipeDto.getCookingTime());
        recipe.setImageId(recipeDto.getImageId());
        return recipe;
    }
    // Recipe -> RecipeDTO
    private RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setCategory(String.valueOf(RecipeCategory.valueOf(recipeDto.getCategory())));
        recipeDto.setCookingTime(recipeDto.getCookingTime());
        recipeDto.setImageId(recipeDto.getImageId());
        return recipeDto;
    }
    // New Recipe
    public RecipeDto createRecipe(RecipeDto createdRecipeDto) {
        Recipe recipe = recipeDtoToRecipe(createdRecipeDto);
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
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        return recipe.orElseThrow(() -> new RecipeNotFoundException(recipeId));
    }

    // save Recipes
    public RecipeDto saveRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeDtoToRecipe(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return toDto(savedRecipe);
    }


    public Recipe createRecipe(String name, RecipeCategory category, CookingTime cookingTime, String instructions) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setRecipeCategory(category);
        recipe.setCookingTime(cookingTime);
        recipe.setInstructions(instructions);
        return recipeRepository.save(recipe);
    }

    public Ingredient createIngredient(String item, boolean isGlutenFree, boolean isLactoseFree) {
        Ingredient ingredient = new Ingredient();
        ingredient.setItem(item);
        ingredient.setGlutenFree(isGlutenFree);
        ingredient.setLactoseFree(isLactoseFree);
        return ingredientsRepository.save(ingredient);
    }

    public void addIngredientToRecipe(Recipe recipe, Ingredient ingredient, String quantityUnit, double quantityValue) {
        RecipeIngredients recipeIngredient = new RecipeIngredients();
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setQuantityUnit(quantityUnit);
        recipeIngredient.setQuantityValue(quantityValue);
        recipeIngredientsRepository.save(recipeIngredient);

        recipe.getIngredients().add(recipeIngredient);
        recipeRepository.save(recipe);
    }

    public Optional<Recipe> findById(Long recipeId) {
        return recipeRepository.findById(recipeId);
    }
}

