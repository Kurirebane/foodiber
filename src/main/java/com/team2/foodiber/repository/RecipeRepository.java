package com.team2.foodiber.repository;

import com.team2.foodiber.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository <Recipe, Long> {


}
