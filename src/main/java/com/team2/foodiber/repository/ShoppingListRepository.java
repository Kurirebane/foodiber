package com.team2.foodiber.repository;

import com.team2.foodiber.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {


    ShoppingList findTopByOrderByIdDesc();

    ShoppingList findTopByOrderByCreatedDateDesc();

    @Query("SELECT sl FROM ShoppingList sl WHERE sl.id = (SELECT MAX(s.id) FROM ShoppingList s)")
    Optional<ShoppingList> findCurrentShoppingList();
}
