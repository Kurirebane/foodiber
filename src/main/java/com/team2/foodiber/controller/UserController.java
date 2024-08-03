package com.team2.foodiber.controller;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

private final UserService userService;

    @PostMapping(path = "/users")
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }

}

