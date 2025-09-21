package com.team2.foodiber.model;

import lombok.Getter;

@Getter
public enum RecipeCategory {
    BREAKFAST("BREAKFast"),
    MAIN_COURSE("MAIN COURSE"),
    SOUP("SOUP"),
    DESSERT("DESSERT"),
    VEGETARIAN("VEGETARIAN");

    private final String dpName;

    RecipeCategory(String dpName){
        this.dpName = dpName;
    }

    public static RecipeCategory fromString(String text){
        return switch (text) {
            case "BREAKFAST" -> BREAKFAST;
            case "MAIN COURSE" -> MAIN_COURSE;
            case "SOUP" -> SOUP;
            case "DESSERT" -> DESSERT;
            case "VEGETARIAN" -> VEGETARIAN;
            default -> throw new IllegalArgumentException("Unknown recipe category" + text);
        };

    }
}

