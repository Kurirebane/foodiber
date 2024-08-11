package com.team2.foodiber.controller;

import com.team2.foodiber.dto.UserDto;
import com.team2.foodiber.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "create-user"; // Ensure this matches your Thymeleaf template name
    }

    @PostMapping("/create")
    public String createUser(UserDto userDto, RedirectAttributes redirectAttributes) {

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("error", "Passwords do not match");
            return "redirect:/create";
        }


        userService.saveUser(userDto);

        redirectAttributes.addFlashAttribute("message", "User created successfully");
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccessMessage(Model model) {
        return "success";
    }
}