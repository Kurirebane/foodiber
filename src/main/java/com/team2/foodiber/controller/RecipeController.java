package com.team2.foodiber.controller;


import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.model.Image;
import com.team2.foodiber.repository.ImageRepository;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.RecipeService;
import com.team2.foodiber.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private ShoppingListService shoppingListService;
    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/create")
    public String showCreateRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeDto());
        return "create-recipe";
    }

    @PostMapping()
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


            List<RecipeDto> allRecipes = recipeService.getAllRecipeDtos();
            model.addAttribute("recipes", allRecipes);


            return "recipes";
        } catch (Exception exception) {
            exception.printStackTrace();
            model.addAttribute("error", "Could not upload this image.");
            return "create-recipe";
        }
    }

    @GetMapping("/success")
    public String showSuccessPage(@RequestParam("recipeId") Long recipeId, Model model) {
        RecipeDto recipe = recipeService.getRecipeDtoById(recipeId);
        if (recipe != null) {
            System.out.println("Recipe ID: " + recipe.getId());
            System.out.println("Recipe Image ID: " + recipe.getImageId());
        } else {
            System.out.println("Recipe not found!");
        }
        model.addAttribute("recipe", recipe);
        return "success";
    }

    @GetMapping()
    public String viewRecipes(Model model) {
        List<RecipeDto> allRecipes = recipeService.getAllRecipeDtos();
        model.addAttribute("recipes", allRecipes);
        return "recipes";
    }
}




