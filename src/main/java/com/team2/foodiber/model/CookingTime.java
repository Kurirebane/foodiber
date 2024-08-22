package com.team2.foodiber.model;

public enum CookingTime {

    FAST_5MIN("About 5 minutes"),
    MEDIUM_15MIN("About 15 minutes"),
    SLOW_30MIN("About 30 minutes"),
    SUPER_SLOW("More than 60 minutes");

    private final String displayName;

    CookingTime(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }

}
