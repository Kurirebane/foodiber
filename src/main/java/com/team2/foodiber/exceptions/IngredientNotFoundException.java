package com.team2.foodiber.exceptions;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(Long ingredientId) {
        System.out.println("not found");
    }
}
