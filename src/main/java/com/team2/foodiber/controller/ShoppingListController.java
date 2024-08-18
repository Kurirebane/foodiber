package com.team2.foodiber.controller;

import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.service.ShoppingListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/recipes")
public class ShoppingListController {


    private final ShoppingListService shoppingListService;


    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

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
@PostMapping("/shopping-list/empty")
    public String emptyShoppingList() {
    System.out.println("empty shoppinglst method called");
    shoppingListService.clearShoppingList();
        return "redirect:/select-category";
    }




}//*************************************************************************************
