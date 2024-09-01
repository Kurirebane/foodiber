package com.team2.foodiber.service;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.exceptions.ImageNotFoundException;
import com.team2.foodiber.exceptions.RecipeNotFoundException;
import com.team2.foodiber.model.*;
import com.team2.foodiber.repository.ImageRepository;
import com.team2.foodiber.repository.IngredientsRepository;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class
RecipeService {


    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;
    private final RecipeIngredientsRepository recipeIngredientsRepository;
    private final ImageRepository imageRepository;

    public RecipeService(RecipeRepository recipeRepository, IngredientsRepository ingredientsRepository,
                         RecipeIngredientsRepository recipeIngredientsRepository, ImageRepository imageRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.recipeIngredientsRepository = recipeIngredientsRepository;
        this.imageRepository = imageRepository;
    }

    private Recipe recipeDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setUserId(recipeDto.getUserId());
        recipe.setName(recipeDto.getName());
        recipe.setRecipeCategory(recipeDto.getRecipeCategory());
        recipe.setCookingTime(recipeDto.getCookingTime());
        recipe.setInstructions(recipeDto.getInstructions());

        if (recipeDto.getImageId() != null) {
            Image image = imageRepository.findById(recipeDto.getImageId())
                    .orElseThrow(() -> new ImageNotFoundException(recipeDto.getImageId()));
            recipe.setImage(image);  // Assuming setImage accepts an Image object
        }

        return recipe;
    }

    public RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setRecipeCategory(recipe.getRecipeCategory());
        recipeDto.setCookingTime(recipe.getCookingTime());
        recipeDto.setInstructions(recipe.getInstructions());
        recipeDto.setImageId(recipe.getImage() != null ? recipe.getImage().getId() : null);
        return recipeDto;
    }

    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeDtoToRecipe(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);;
        return toDto(savedRecipe);

    }

    public RecipeDto getRecipeDtoById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));
        return toDto(recipe);
    }

    public List<Recipe> getRecipesByCategory(RecipeCategory category) {
        return recipeRepository.findByRecipeCategory(category);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));
    }

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

    public List<RecipeDto> getAllRecipeDtos() {
        List<Recipe> recipes = recipeRepository.findAll();
        List<RecipeDto> recipeDtos = recipes.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return recipeDtos;
    }


    public Optional<Recipe> findById(Long recipeId) {
        return recipeRepository.findById(recipeId);
    }
}
