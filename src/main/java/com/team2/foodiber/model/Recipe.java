package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private RecipeCategory recipeCategory;
    @Enumerated(EnumType.STRING)
    private CookingTime cookingTime;



}
