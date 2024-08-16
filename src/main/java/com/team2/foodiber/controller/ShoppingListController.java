package com.team2.foodiber.controller;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/recipes")
public class ShoppingListController {

    @Autowired
    private RecipeIngredientsRepository recipeIngredientsRepository;

    private final ShoppingListService shoppingListService;

//
//    @GetMapping("/shopping-list")
//    public String getShoppingList(Model model) {
//        ShoppingList shoppingList = shoppingListService.getLatestShoppingList(); // Assuming you have such a method
//        model.addAttribute("shoppingList", shoppingList);
//        return "shopping-list";
//    }

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

//    @GetMapping
//    public String getShoppingList(Model model) {
//        ShoppingList shoppingList = shoppingListService.getLatestShoppingList();
//        model.addAttribute("shoppingList", shoppingList);
//        return "shopping-list"; // Ensure this matches the Thymeleaf template name
//    }
@GetMapping("/shopping-list") // This should match the exact path in the redirect
public String getShoppingList(Model model) {
    ShoppingList shoppingList = shoppingListService.getLatestShoppingList();
    if (shoppingList == null || shoppingList.getItems().isEmpty()) {
        model.addAttribute("message", "Your shopping list is empty.");
        shoppingList = new ShoppingList(); // Initialize an empty shopping list
    }
    model.addAttribute("shoppingList", shoppingList);
    return "shopping-list"; // Ensure this matches the Thymeleaf template name
}
}
