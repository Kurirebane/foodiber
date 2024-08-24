package com.team2.foodiber.service;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.exceptions.ImageNotFoundException;
import com.team2.foodiber.exceptions.RecipeNotFoundException;
import com.team2.foodiber.model.*;
import com.team2.foodiber.repository.IngredientsRepository;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.repository.ImageRepository; // Import this if you are using ImageRepository
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;
    private final RecipeIngredientsRepository recipeIngredientsRepository;
    private final ImageRepository imageRepository; // Add ImageRepository

    public RecipeService(RecipeRepository recipeRepository, IngredientsRepository ingredientsRepository,
                         RecipeIngredientsRepository recipeIngredientsRepository, ImageRepository imageRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.recipeIngredientsRepository = recipeIngredientsRepository;
        this.imageRepository = imageRepository; // Initialize ImageRepository
    }

    private Recipe recipeDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setUserId(recipeDto.getUserId());
        recipe.setName(recipeDto.getName());
        recipe.setRecipeCategory(recipeDto.getRecipeCategory());
        recipe.setCookingTime(recipeDto.getCookingTime());
        recipe.setInstructions(recipeDto.getInstructions());

        // Fetch and set the image if imageId is provided
        if (recipeDto.getImageId() != null) {
            Image image = imageRepository.findById(recipeDto.getImageId())
                    .orElseThrow(() -> new ImageNotFoundException(recipeDto.getImageId()));
            recipe.setImage(image);
        }

        return recipe;
    }

    private RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setUserId(recipe.getUserId());
        recipeDto.setName(recipe.getName());
        recipeDto.setRecipeCategory(recipe.getRecipeCategory());
        recipeDto.setCookingTime(recipe.getCookingTime());
        recipeDto.setInstructions(recipe.getInstructions());

        if (recipe.getImage() != null) {
            recipeDto.setImageId(recipe.getImage().getId());
        }

        return recipeDto;
    }

    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeDtoToRecipe(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
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

    public Optional<Recipe> findById(Long recipeId) {
        return recipeRepository.findById(recipeId);
    }
}
