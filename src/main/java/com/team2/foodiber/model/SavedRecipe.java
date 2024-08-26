package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SavedRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long userId;
    private String instructions;
    private Long imageId;

    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;

    @Enumerated(EnumType.STRING)
    private CookingTime cookingTime;


    public SavedRecipe() {}


    public SavedRecipe(Recipe recipe) {
        this.name = recipe.getName();
        this.userId = recipe.getUserId();
        this.instructions = recipe.getInstructions();

        this.recipeCategory = recipe.getRecipeCategory();
        this.cookingTime = recipe.getCookingTime();

    }

}
