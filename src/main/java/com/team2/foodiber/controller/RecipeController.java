package com.team2.foodiber.controller;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.model.Image;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.repository.ImageRepository;
import com.team2.foodiber.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final ImageRepository imageRepository;

    @GetMapping("/create")
    public String showCreateRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeDto());
        return "create-recipe";
    }

    @PostMapping
    public String createRecipe(@ModelAttribute RecipeDto recipeDto,
                               @RequestParam("image") MultipartFile file, Model model) {
        try {
            if (!file.isEmpty()) {
                Image image = new Image();
                image.setName(file.getOriginalFilename());
                image.setType(file.getContentType());
                image.setSize(file.getSize());
                image.setImageData(file.getBytes());

                Image savedImage = imageRepository.save(image);
                recipeDto.setImageId(savedImage.getId());
            }


                RecipeDto savedRecipe = recipeService.createRecipe(recipeDto);
                model.addAttribute("recipe", savedRecipe);
                return "redirect:/recipes/success";
            } catch (Exception exception) {
            exception.printStackTrace();
            model.addAttribute("Error", "Could not upload this image.");
            return "create-recipe";
        }

    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @GetMapping("/user-recipes")
    public String getUserCreatedRecipes(Model model) {
        List<RecipeDto> userRecipes = recipeService.getUserRecipes();
        model.addAttribute("userRecipes", userRecipes);
        return "user-created-recipes";
    }
}