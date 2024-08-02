package com.team2.foodiber.repository;

import com.team2.foodiber.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository <Ingredients, Long> {
}
