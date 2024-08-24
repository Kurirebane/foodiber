package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;

    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;

    @Enumerated(EnumType.STRING)
    private CookingTime cookingTime;

    @Column(length = 2000)
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RecipeIngredients> ingredients = new HashSet<>();
}





