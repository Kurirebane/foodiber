package com.team2.foodiber.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private long imageId;

    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;

    @Enumerated(EnumType.STRING)
    private CookingTime cookingTime;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredients> ingredients = new ArrayList<>();

}
