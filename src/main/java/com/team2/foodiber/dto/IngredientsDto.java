package com.team2.foodiber.dto;

import lombok.Data;

@Data
public class IngredientsDto {
    private String item;
    private boolean isGlutenFree;
    private boolean isLactoseFree;
}
