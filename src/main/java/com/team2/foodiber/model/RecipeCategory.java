package com.team2.foodiber.model;

public enum RecipeCategory {
    BREAKFAST("Breakfast"), MAIN_COURSE("Main Course"), SOUP("Soup"), DESSERT("Dessert"), VEGETARIAN("Vegetarian");

    private final String displayName;

    private RecipeCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

