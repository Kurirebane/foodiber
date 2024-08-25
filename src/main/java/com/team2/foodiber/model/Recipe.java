package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)  // Many recipes can share the same image
    @JoinColumn(name = "image_id")  // Specifies the foreign key column name in the recipes table
    private Image image;

    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;

    @Enumerated(EnumType.STRING)
    private CookingTime cookingTime;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredients> ingredients = new ArrayList<>();

    @ManyToMany(mappedBy = "recipes")
    private List<MealPlanDay> mealPlanDays = new ArrayList<>();
}
