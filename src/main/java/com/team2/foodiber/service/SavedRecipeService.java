package com.team2.foodiber.service;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.model.SavedRecipe;
import com.team2.foodiber.repository.SavedRecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SavedRecipeService {

    private final SavedRecipeRepository savedRecipeRepository;

    public void saveRecipeToSavedRecipe(RecipeDto recipeDto){
        SavedRecipe savedRecipe = new SavedRecipe();
        savedRecipe.setId(recipeDto.getId());
        savedRecipe.setRecipeId(recipeDto.getRecipeId());
        savedRecipe.setName(recipeDto.getName());
        savedRecipe.setRecipeCategory(recipeDto.getRecipeCategory());
        savedRecipe.setCookingTime(recipeDto.getCookingTime());
        savedRecipe.setInstructions(recipeDto.getInstructions());
        savedRecipe.setImageId(recipeDto.getImageId());

        savedRecipeRepository.save(savedRecipe);
    }
}
