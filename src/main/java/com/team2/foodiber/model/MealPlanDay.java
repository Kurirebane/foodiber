package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class MealPlanDay {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Recipe> recipes;
//
//    public MealPlanDay() {
//        this.recipes = new ArrayList<>(); // Initialize the list to prevent null reference
//    }
@ManyToMany
@JoinTable(
        name = "meal_plan_day_recipes",
        joinColumns = @JoinColumn(name = "meal_plan_day_id"),
        inverseJoinColumns = @JoinColumn(name = "recipe_id")
)
private List<Recipe> recipes = new ArrayList<>();
}
