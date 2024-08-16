package com.team2.foodiber.repository;

import com.team2.foodiber.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {


    ShoppingList findTopByOrderByIdDesc();

    ShoppingList findTopByOrderByCreatedDateDesc();
}
