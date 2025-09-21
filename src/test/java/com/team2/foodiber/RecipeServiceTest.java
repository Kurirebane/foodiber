package com.team2.foodiber;

import com.team2.foodiber.dto.RecipeDto;
import com.team2.foodiber.model.CookingTime;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import com.team2.foodiber.repository.ImageRepository;
import com.team2.foodiber.repository.IngredientsRepository;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private  IngredientsRepository ingredientsRepository;
    @Mock
    private  RecipeIngredientsRepository recipeIngredientsRepository;
    @Mock
    private  ImageRepository imageRepository;


    @BeforeEach
    void setUp() {


    }
    @Test
    public void testCreateRecipe() {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(1L);
        recipeDto.setName("Avocado Toast");
        recipeDto.setRecipeCategory(RecipeCategory.BREAKFAST);
        recipeDto.setCookingTime(CookingTime.FAST_5MIN);
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setUserId(1L);
        recipe.setName("Avocado Toast");
        recipe.setRecipeCategory(RecipeCategory.BREAKFAST);
        recipe.setCookingTime(CookingTime.FAST_5MIN);
        RecipeService recipeService1 = new RecipeService(recipeRepository, ingredientsRepository, recipeIngredientsRepository, imageRepository);
        when(recipeRepository.save(any())).thenReturn(recipe);
        RecipeDto savedRecipe = recipeService1.createRecipe(recipeDto);
        Assertions.assertEquals(savedRecipe.getName(), recipeDto.getName());
        Assertions.assertEquals(savedRecipe.getRecipeCategory(), recipeDto.getRecipeCategory());
        Assertions.assertEquals(savedRecipe.getCookingTime(), recipeDto.getCookingTime());
        verifyNoMoreInteractions(recipeRepository);
    }

}
