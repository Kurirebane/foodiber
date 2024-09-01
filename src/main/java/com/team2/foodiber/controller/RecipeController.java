package com.team2.foodiber.controller;


import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.model.Image;
import com.team2.foodiber.repository.ImageRepository;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.RecipeService;
import com.team2.foodiber.service.SavedRecipeService;
import com.team2.foodiber.service.ShoppingListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;
    private final ShoppingListService shoppingListService;
    private final ImageRepository imageRepository;
    private final SavedRecipeService savedRecipeService;

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
                log.info("Image saved with ID: " + savedImage.getId());
            }

            RecipeDto savedRecipe = recipeService.createRecipe(recipeDto);
            savedRecipeService.saveRecipeToSavedRecipe(savedRecipe);

            return "redirect:/recipes/success?recipeId=" + savedRecipe.getId();
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
            model.addAttribute("recipe", recipe);
            log.info("Recipe Details: " + recipe); // for the debug
            return "success";
        } else {
            model.addAttribute("error", "Recipe not found.");
            return "error";
        }
    }

    @GetMapping("/recipe")
    public String viewSavedRecipes(Model model) {
        List<RecipeDto> allRecipes = recipeService.getAllRecipeDtos();
        System.out.println("All Recipes: " + allRecipes); // Debugging line
        model.addAttribute("recipes", allRecipes);
        return "saved-recipes"; // Ensure this matches your Thymeleaf template name
    }
}




