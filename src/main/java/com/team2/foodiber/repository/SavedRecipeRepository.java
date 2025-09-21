package com.team2.foodiber.repository;

import com.team2.foodiber.model.SavedRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedRecipeRepository extends JpaRepository<SavedRecipe, Long> {

}
