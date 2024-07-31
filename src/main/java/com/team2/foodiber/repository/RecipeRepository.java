package com.team2.foodiber.repository;

import com.team2.foodiber.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository <Recipe, Long> {


}
