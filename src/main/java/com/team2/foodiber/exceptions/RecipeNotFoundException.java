package com.team2.foodiber.exceptions;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(long id) {
        super("Recipe with id" + id + " not found");
    }
}
