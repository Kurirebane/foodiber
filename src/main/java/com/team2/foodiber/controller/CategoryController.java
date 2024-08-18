package com.team2.foodiber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("/recipes/select-category")
    public String selectCategory(Model model) {
        // Logic to load categories or any other necessary data
        return "select-category"; // This should be the name of your Thymeleaf template for category selection
    }
}
