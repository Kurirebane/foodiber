package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recipe ingredients")
public class RecipeIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredientsId", referencedColumnName = "id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "recipeId", referencedColumnName = "id")
    private Recipe recipe;
    private String quantity;

}
