package com.team2.foodiber.model;

import lombok.Data;

@Data
public class Ingredients {
    private String item;
    private boolean isGlutenFree;
    private boolean isLactoseFree;
}
