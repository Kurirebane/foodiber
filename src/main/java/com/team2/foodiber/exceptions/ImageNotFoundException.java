package com.team2.foodiber.exceptions;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(Long imageId) {
        super("Could not find image with id " + imageId);
    }
}
