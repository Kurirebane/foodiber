package com.team2.foodiber.controller;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.RecipeService;
import com.team2.foodiber.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping("/create")
    public String showCreateRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeDto());
        return "create-recipe";
    }

    @PostMapping
    public String createRecipe(RecipeDto recipeDto, Model model) {
        RecipeDto savedRecipe = recipeService.createRecipe(recipeDto);
        model.addAttribute("recipe", savedRecipe);
        return "redirect:/recipes/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @PostMapping("/saveIngredients")
    public String saveIngredients(
            @RequestParam Long recipeId,
            @RequestParam Map<Long, String> quantities, // This is for ingredient quantities
            @RequestParam int servings, // This is for the number of servings
            Model model) {

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + recipeId));

        // Logic to handle the updated quantities and servings
        shoppingListService.addIngredientsToShoppingList(recipe.getIngredients(), servings);

        return "redirect:/recipes/shopping-list"; // Redirect to the shopping list page
    }
//    @GetMapping("/shopping-list")
//    public String viewShoppingList(Model model) {
//        ShoppingList shoppingList = shoppingListService.getLatestShoppingList();
//        model.addAttribute("shoppingList", shoppingList);
//        return "shopping-list"; // View name for shopping list
//    }

}

