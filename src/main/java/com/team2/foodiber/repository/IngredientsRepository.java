package com.team2.foodiber.repository;

import com.team2.foodiber.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository <Ingredient, Long> {

}


