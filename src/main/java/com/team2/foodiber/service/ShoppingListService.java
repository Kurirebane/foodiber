package com.team2.foodiber.service;

import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.model.ShoppingListItem;
import com.team2.foodiber.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    // Saving ingredients to shopping list and trying to make it so it checks if item already exists and adds quantities together so the same ingredient will appear on one line
    public void addIngredientsToShoppingList(List<RecipeIngredients> selectedIngredients, int servings) {
        ShoppingList shoppingList = getLatestShoppingList();

        for (RecipeIngredients ingredient : selectedIngredients) {
            double adjustedQuantity = ingredient.getQuantityValue() * servings;

            if (adjustedQuantity > 0) {
                Optional<ShoppingListItem> existingItemOpt = shoppingList.getItems().stream()
                        .filter(item -> item.getIngredient().equals(ingredient.getIngredient()) &&
                                item.getQuantityUnit().equals(ingredient.getQuantityUnit()))
                        .findFirst();

                if (existingItemOpt.isPresent()) {
                    ShoppingListItem existingItem = existingItemOpt.get();
                    existingItem.setQuantityValue(existingItem.getQuantityValue() + adjustedQuantity);
                } else {
                    ShoppingListItem newItem = new ShoppingListItem();
                    newItem.setIngredient(ingredient.getIngredient());
                    newItem.setQuantityValue(adjustedQuantity);
                    newItem.setQuantityUnit(ingredient.getQuantityUnit());
                    newItem.setShoppingList(shoppingList);

                    shoppingList.getItems().add(newItem);
                }
            }
        }

        shoppingListRepository.save(shoppingList);
    }
    public ShoppingList getLatestShoppingList() {
        ShoppingList shoppingList = shoppingListRepository.findTopByOrderByCreatedDateDesc();
        if (shoppingList == null) {
            shoppingList = new ShoppingList();
            shoppingList.setItems(new ArrayList<>());
            shoppingListRepository.save(shoppingList);
        }
        return shoppingList;
    }

    public void clearShoppingList() {
        ShoppingList shoppingList = getLatestShoppingList();
        if (shoppingList != null) {
            shoppingList.getItems().clear();
            shoppingListRepository.save(shoppingList);
        }
    }


}//*********************************************************************************************************************
