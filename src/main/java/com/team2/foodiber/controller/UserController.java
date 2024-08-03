package com.team2.foodiber.controller;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create-user")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "create-users";
    }

    @PostMapping(path = "/users")
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }
}
