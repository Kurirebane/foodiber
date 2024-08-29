package com.team2.foodiber.controller;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class ShoppingListController {

    @Autowired
    private final ShoppingListService shoppingListService;
    @Autowired
    private RecipeRepository recipeRepository;


    @GetMapping("/shopping-list")
public String getShoppingList(Model model) {
    ShoppingList shoppingList = shoppingListService.getLatestShoppingList();
    if (shoppingList == null || shoppingList.getItems().isEmpty()) {
        model.addAttribute("message", "Your shopping list is empty.");
        shoppingList = new ShoppingList();
    }
    model.addAttribute("shoppingList", shoppingList);
    return "shopping-list";
}

    @PostMapping("/saveIngredients")
    public String saveIngredients(
            @RequestParam Long recipeId,
            @RequestParam Map<Long, String> quantities,
            @RequestParam int servings,
            @RequestParam List<Long> selectedIngredients,
            Model model) {

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + recipeId));

        // Filtering selected ingredients
        List<RecipeIngredients> ingredientsToAdd = recipe.getIngredients().stream()
                .filter(ingredient -> selectedIngredients.contains(ingredient.getId()))
                .collect(Collectors.toList());

        // Adding ingredients to the shopping list
        shoppingListService.addIngredientsToShoppingList(ingredientsToAdd, servings);

        return "redirect:/recipes/shopping-list";
    }
@PostMapping("/shopping-list/empty")
    public String emptyShoppingList() {
    System.out.println("empty shoppinglst method called");
    shoppingListService.clearShoppingList();
        return "redirect:/select-category";
    }




}//*************************************************************************************
