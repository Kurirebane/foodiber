package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingListItem> items = new ArrayList<>();
    @Column
    private LocalDateTime createdDate;

    public void addIngredient(ShoppingListItem ingredient) {
        items.add(ingredient);
        ingredient.setShoppingList(this);
    }

    public void removeIngredient(ShoppingListItem ingredient) {
        items.remove(ingredient);
        ingredient.setShoppingList(null);
    }
}
