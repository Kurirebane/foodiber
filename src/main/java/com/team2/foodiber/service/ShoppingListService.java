package com.team2.foodiber.service;

import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.model.ShoppingListItem;
import com.team2.foodiber.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public void addIngredientsToShoppingList(List<RecipeIngredients> ingredients, int servings) {
        ShoppingList shoppingList = getLatestShoppingList();
        for (RecipeIngredients recipeIngredient : ingredients) {
            double adjustedQuantity = recipeIngredient.getQuantityValue() * servings;
            ShoppingListItem shoppingListItem = new ShoppingListItem();
            shoppingListItem.setIngredient(recipeIngredient.getIngredient());
            shoppingListItem.setQuantityValue(adjustedQuantity);
            shoppingListItem.setQuantityUnit(recipeIngredient.getQuantityUnit());
            shoppingListItem.setShoppingList(shoppingList);
            shoppingList.getItems().add(shoppingListItem);
        }
        shoppingListRepository.save(shoppingList);
    }

    public ShoppingList getLatestShoppingList() {
        ShoppingList shoppingList = shoppingListRepository.findTopByOrderByCreatedDateDesc();
        if (shoppingList == null) {
            shoppingList = new ShoppingList();
            shoppingList.setItems(new ArrayList<>()); // Initialize with an empty list
            shoppingListRepository.save(shoppingList); // Optional: Save to persist
        }
        return shoppingList;
    }


//    public ShoppingList addIngredientsToShoppingList(List<RecipeIngredients> recipeIngredients, int servings) {
//        // Retrieve or create the latest shopping list
//        ShoppingList shoppingList = getLatestShoppingList();
//
//        // Iterate over each recipe ingredient
//        for (RecipeIngredients recipeIngredient : recipeIngredients) {
//            // Extract quantity value and unit from RecipeIngredients
//            double quantityValue = recipeIngredient.getQuantityValue() * servings;
//            String quantityUnit = recipeIngredient.getQuantityUnit();
//
//            // Check if this ingredient is already in the shopping list
//            ShoppingListItem existingItem = shoppingList.getItems().stream()
//                    .filter(item -> item.getIngredient().equals(recipeIngredient.getIngredient())
//                            && item.getQuantityUnit().equals(quantityUnit)) // match both ingredient and unit
//                    .findFirst()
//                    .orElse(null);
//
//            if (existingItem != null) {
//                // If the ingredient with the same unit is already in the list, update the quantity
//                existingItem.setQuantityValue(existingItem.getQuantityValue() + quantityValue);
//            } else {
//                // If not, create a new ShoppingListItem and add it to the shopping list
//                ShoppingListItem newItem = new ShoppingListItem();
//                newItem.setIngredient(recipeIngredient.getIngredient());
//                newItem.setQuantityValue(quantityValue);
//                newItem.setQuantityUnit(quantityUnit);
//                shoppingList.getItems().add(newItem);
//            }
//        }
//
//        // Save and return the updated shopping list
//        return shoppingListRepository.save(shoppingList);
//    }

//    public ShoppingList addIngredientsToShoppingList(List<RecipeIngredients> recipeIngredients, int servings) {
//        ShoppingList shoppingList = new ShoppingList();
//
//        for (RecipeIngredients recipeIngredient : recipeIngredients) {
//            ShoppingListItem item = new ShoppingListItem();
//            item.setIngredient(recipeIngredient.getIngredient());
//
//            // Calculate the new quantity based on the number of servings
//            double originalQuantity = recipeIngredient.getQuantityValue();
//            double adjustedQuantity = originalQuantity * servings; // Adjust based on the servings
//            String quantity = String.valueOf(adjustedQuantity) + " " + recipeIngredient.getQuantityUnit();
//
//            item.setQuantity(quantity);
//            item.setShoppingList(shoppingList);
//            shoppingList.getItems().add(item);
//        }
//
//        // Save the shopping list with all items
//        return shoppingListRepository.save(shoppingList);
//    }


//        public ShoppingList getLatestShoppingList() {
//            ShoppingList latestShoppingList = shoppingListRepository.findTopByOrderByCreatedDateDesc();
//
//            if (latestShoppingList == null) {
//                // If no shopping list exists, create a new one
//                latestShoppingList = new ShoppingList();
//                latestShoppingList.setCreatedDate(LocalDateTime.now()); // Assuming you have a createdDate field
//                // Add any other default values or initialization here
//
//                latestShoppingList = shoppingListRepository.save(latestShoppingList);
//            }
//
//            return latestShoppingList;
//        }


}
