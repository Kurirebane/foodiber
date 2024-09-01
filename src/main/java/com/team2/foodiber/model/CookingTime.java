package com.team2.foodiber.model;

public enum CookingTime {

    FAST_5MIN("About 5 minutes"), MEDIUM_15MIN("About 15 minutes"), SLOW_30MIN("About 30 minutes"), SUPER_SLOW("More than 60 minutes");

    private final String displayName;

    CookingTime(String displayName) {
        this.displayName = displayName;
    }

    public static CookingTime fromString(String text) {
        return switch (text) {
            case "5" -> FAST_5MIN;
            case "15" -> MEDIUM_15MIN;
            case "30" -> SLOW_30MIN;
            case "60" -> SUPER_SLOW;
            default -> throw new IllegalArgumentException("Unknown cooking time: " + text);
        };
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

