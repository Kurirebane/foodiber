package com.team2.foodiber.service;

import com.team2.foodiber.model.Ingredient;
import com.team2.foodiber.model.RecipeIngredients;
import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.model.ShoppingListItem;
import com.team2.foodiber.repository.IngredientsRepository;
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
    @Autowired
    private IngredientsRepository ingredientsRepository;


    public void addIngredientsToShoppingList(List<RecipeIngredients> recipeIngredients, int servings) {
        ShoppingList shoppingList = shoppingListRepository.findCurrentShoppingList()
                .orElseGet(() -> {
                    ShoppingList newShoppingList = new ShoppingList();
                    newShoppingList.setCreatedDate(LocalDateTime.now());
                    return shoppingListRepository.save(newShoppingList);
                });

        for (RecipeIngredients recipeIngredient : recipeIngredients) {
            Ingredient ingredient = recipeIngredient.getIngredient();
            double quantity = recipeIngredient.getQuantityValue() * servings;
            ShoppingListItem item = new ShoppingListItem();
            item.setIngredient(ingredient);
            item.setQuantityValue(quantity);
            item.setQuantityUnit(recipeIngredient.getQuantityUnit());
            item.setShoppingList(shoppingList);

            shoppingList.addIngredient(item);
        }

        shoppingListRepository.save(shoppingList); // Save changes to the shopping list
    }


    public ShoppingList getCurrentShoppingList() {
        return shoppingListRepository.findCurrentShoppingList()
                .orElseGet(() -> {
                    ShoppingList newShoppingList = new ShoppingList();
                    newShoppingList.setCreatedDate(LocalDateTime.now());
                    return shoppingListRepository.save(newShoppingList); // Save the new shopping list and return it
                });
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
}
