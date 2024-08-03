package com.team2.foodiber.exceptions;

public class UsernameOrEmailIsAlreadyExisted extends Throwable{

    public UsernameOrEmailIsAlreadyExisted(String username) {
        super("User with Username or Email: " + username + " already existed");
    }
}
