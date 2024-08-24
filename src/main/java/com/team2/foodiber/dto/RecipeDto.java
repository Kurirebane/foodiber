package com.team2.foodiber.dto;

import com.team2.foodiber.model.CookingTime;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import lombok.Data;

@Data
public class RecipeDto {
    private Long id;
    private Long userId;
    private String name;
    private RecipeCategory recipeCategory; // Enum directly
    private CookingTime cookingTime; // Enum directly
    private String instructions;
    private Long imageId;

    // No-argument constructor
    public RecipeDto() {}

    // Constructor to initialize from Recipe entity
    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.userId = recipe.getUserId();
        this.name = recipe.getName();
        this.recipeCategory = recipe.getRecipeCategory(); // Directly use Enum
        this.cookingTime = recipe.getCookingTime(); // Directly use Enum
        this.instructions = recipe.getInstructions();
        if (recipe.getImage() != null) {
            this.imageId = recipe.getImage().getId(); // Assuming Recipe has a getImage() method
        }
    }
}
