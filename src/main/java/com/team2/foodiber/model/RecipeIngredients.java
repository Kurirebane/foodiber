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

    private Long ingredientsId;// Kas see peaks olema sama mis ingredients klass ja seal field id?
    private Long recipeId;
    private String amounts;
}
