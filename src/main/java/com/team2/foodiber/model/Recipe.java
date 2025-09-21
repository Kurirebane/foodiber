package com.team2.foodiber.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;

    @Enumerated(EnumType.STRING)
    private CookingTime cookingTime;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredients> ingredients = new ArrayList<>();

    @ManyToMany(mappedBy = "recipes")
    private List<MealPlanDay> mealPlanDays = new ArrayList<>();

    public Long getImageId() {
        return image != null ? image.getId() : null;
    }

    @Component
    public static class StringToCookingTimeConverter implements Converter<String, CookingTime> {

        @Override
        public CookingTime convert(String source) {
            return CookingTime.fromString(source);
        }
    }
}
