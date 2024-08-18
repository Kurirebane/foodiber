package com.team2.foodiber.dto;

import com.team2.foodiber.model.CookingTime;
import lombok.Data;

@Data
public class RecipeDto {

    private String name;
    private String category;
    private CookingTime cookingTime;
    private String ingredients;
    private Long imageId;

}
