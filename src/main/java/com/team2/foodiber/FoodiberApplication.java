package com.team2.foodiber;

import com.team2.foodiber.model.*;
import com.team2.foodiber.repository.IngredientsRepository;
import com.team2.foodiber.repository.RecipeIngredientsRepository;
import com.team2.foodiber.repository.RecipeRepository;
import com.team2.foodiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class FoodiberApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private IngredientsRepository ingredientsRepository;
	@Autowired
	private RecipeIngredientsRepository recipeIngredientsRepository;



	public static void main(String[] args) {
		SpringApplication.run(FoodiberApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		// ********************************* RECIPES *********************************************
//		Recipe recipe1 = new Recipe();
//		recipe1.setName("Pasta bolognese");
//		recipe1.setRecipeCategory(RecipeCategory.MAIN_COURSE);
//		recipe1.setCookingTime(CookingTime.SLOW_30MIN);
//		recipeRepository.save(recipe1);
//
//		Recipe recipe2 = new Recipe();
//		recipe2.setName("Chia seed pancakes with greek yoghurt");
//		recipe2.setRecipeCategory(RecipeCategory.BREAKFAST);
//		recipe2.setCookingTime(CookingTime.MEDIUM_15MIN);
//		recipeRepository.save(recipe2);
//
//		Recipe recipe3 = new Recipe();
//		recipe3.setName("Oat porridge with fresh berries and honey drizzle");
//		recipe3.setRecipeCategory(RecipeCategory.BREAKFAST);
//		recipe3.setCookingTime(CookingTime.FAST_5MIN);
//		recipeRepository.save(recipe3);
//
//		Recipe recipe4 = new Recipe();
//		recipe4.setName("Creamy roasted pumpkin soup");
//		recipe4.setRecipeCategory(RecipeCategory.SOUP);
//		recipe4.setCookingTime(CookingTime.SLOW_30MIN);
//		Recipe savedPumpkinSoup = recipeRepository.save(recipe4);
//
//		Recipe recipe5 = new Recipe();
//		recipe5.setName("Avocado toast");
//		recipe5.setRecipeCategory(RecipeCategory.BREAKFAST);
//		recipe5.setCookingTime(CookingTime.FAST_5MIN);
//		Recipe savedAvocadoToast = recipeRepository.save(recipe5);
//
//		Recipe recipe6 = new Recipe();
//		recipe6.setName("Chickpea curry");
//		recipe6.setRecipeCategory(RecipeCategory.VEGETARIAN);
//		recipe6.setCookingTime(CookingTime.SLOW_30MIN);
//		recipeRepository.save(recipe6);
//
//		Recipe recipe7 = new Recipe();
//		recipe7.setName("Oven roasted salmon and vegetables");
//		recipe7.setRecipeCategory(RecipeCategory.MAIN_COURSE);
//		recipe7.setCookingTime(CookingTime.SLOW_30MIN);
//		recipeRepository.save(recipe7);
//
//		Recipe recipe8 = new Recipe();
//		recipe8.setName("Vegetarian lasagne");
//		recipe8.setRecipeCategory(RecipeCategory.VEGETARIAN);
//		recipe8.setCookingTime(CookingTime.SLOW_30MIN);
//		recipeRepository.save(recipe8);
//
//		Recipe recipe9 = new Recipe();
//		recipe9.setName("Oven buckwheat with fried ham");
//		recipe9.setRecipeCategory(RecipeCategory.MAIN_COURSE);
//		recipe9.setCookingTime(CookingTime.SLOW_30MIN);
//		recipeRepository.save(recipe9);
//
//		Recipe recipe10 = new Recipe();
//		recipe10.setName("Greek yoghurt with mango puree and crunchy granola");
//		recipe10.setRecipeCategory(RecipeCategory.DESSERT);
//		recipe10.setCookingTime(CookingTime.FAST_5MIN);
//		recipeRepository.save(recipe10);
//
//		Recipe recipe11 = new Recipe();
//		recipe11.setName("Poor knights");
//		recipe11.setRecipeCategory(RecipeCategory.DESSERT);
//		recipe11.setCookingTime(CookingTime.MEDIUM_15MIN);
//		recipeRepository.save(recipe11);
//
//		//*********************' INGREDIENTS *********************************************
//
//		Ingredient ingredientCarrot = new Ingredient();
//		ingredientCarrot.setItem("carrot");
//		ingredientCarrot.setGlutenFree(true);
//		ingredientCarrot.setLactoseFree(true);
//		Ingredient savedIngredientsCarrot = ingredientsRepository.save(ingredientCarrot);
//
//		Ingredient ingredientPotato = new Ingredient();
//		ingredientPotato.setItem("potato");
//		ingredientPotato.setGlutenFree(true);
//		ingredientPotato.setLactoseFree(true);
//		Ingredient savedIngredientsPotato = ingredientsRepository.save(ingredientPotato);
//
//		Ingredient ingredientPumpkin = new Ingredient();
//		ingredientPumpkin.setItem("pumpkin");
//		ingredientPumpkin.setGlutenFree(true);
//		ingredientPumpkin.setLactoseFree(true);
//		Ingredient savedIngredientsPumpkin = ingredientsRepository.save(ingredientPumpkin);
//
//		Ingredient ingredientOnion = new Ingredient();
//		ingredientOnion.setItem("onion");
//		ingredientOnion.setGlutenFree(true);
//		ingredientOnion.setLactoseFree(true);
//		Ingredient savedIngredientsOnion = ingredientsRepository.save(ingredientOnion);
//
//		Ingredient ingredientOliveOil = new Ingredient();
//		ingredientOliveOil.setItem("olive oil");
//		ingredientOliveOil.setGlutenFree(true);
//		ingredientOliveOil.setLactoseFree(true);
//		Ingredient savedIngredientsOliveOil= ingredientsRepository.save(ingredientOliveOil);
//
//		Ingredient ingredientCream = new Ingredient();
//		ingredientCream.setItem("20% coffee cream");
//		ingredientCream.setGlutenFree(true);
//		ingredientCream.setLactoseFree(false);
//		Ingredient savedIngredientsCream = ingredientsRepository.save(ingredientCream);
//
//		Ingredient ingredientGarlic = new Ingredient();
//		ingredientGarlic.setItem("garlic");
//		ingredientGarlic.setGlutenFree(true);
//		ingredientGarlic.setLactoseFree(true);
//		Ingredient savedIngredientsGarlic = ingredientsRepository.save(ingredientGarlic);
//
//		Ingredient ingredientLeek = new Ingredient();
//		ingredientLeek.setItem("leek");
//		ingredientLeek.setGlutenFree(true);
//		ingredientLeek.setLactoseFree(true);
//		Ingredient savedIngredientsLeek = ingredientsRepository.save(ingredientLeek);
//
//		 //*************** RECIPE INGREDIENTS ******************************************
//		RecipeIngredients recipeIngredientsCarrot = new RecipeIngredients();
//		recipeIngredientsCarrot.setIngredient(savedIngredientsCarrot);
//		recipeIngredientsCarrot.setRecipe(savedPumpkinSoup);
//		recipeIngredientsCarrot.setQuantityPerServing("3");
//		recipeIngredientsRepository.save(recipeIngredientsCarrot);
//
//
//		RecipeIngredients recipeIngredientsOliveOil = new RecipeIngredients();
//		recipeIngredientsOliveOil.setIngredient(savedIngredientsOliveOil);
//		recipeIngredientsOliveOil.setRecipe(savedPumpkinSoup);
//		recipeIngredientsOliveOil.setQuantityPerServing("3 tablespoons");
//        recipeIngredientsRepository.save(recipeIngredientsOliveOil);
//
//		RecipeIngredients recipeIngredientsPotato = new RecipeIngredients();
//		recipeIngredientsPotato.setIngredient(savedIngredientsPotato);
//		recipeIngredientsPotato.setRecipe(savedPumpkinSoup);
//		recipeIngredientsPotato.setQuantityPerServing("100 gr");
//		recipeIngredientsRepository.save(recipeIngredientsPotato);
//
//		RecipeIngredients recipeIngredientsPumpkin = new RecipeIngredients();
//		recipeIngredientsPumpkin.setIngredient(savedIngredientsPumpkin);
//		recipeIngredientsPumpkin.setRecipe(savedPumpkinSoup);
//		recipeIngredientsPumpkin.setQuantityPerServing("200 gr");
//		recipeIngredientsRepository.save(recipeIngredientsPumpkin);
//
//
//		savedPumpkinSoup.getIngredients().add(recipeIngredientsCarrot);
//		savedPumpkinSoup.getIngredients().add(recipeIngredientsOliveOil);
//		savedPumpkinSoup.getIngredients().add(recipeIngredientsPumpkin);
//		savedPumpkinSoup.getIngredients().add(recipeIngredientsPotato);
//		recipeRepository.save(savedPumpkinSoup);







//		List<Recipe> recipes = recipeRepository.findAll();
//
//		for (Recipe recipe : recipes) {
//			if (recipe.getName().equals("Pasta bolognese")) {
//				recipeService.addIngredientToRecipe(recipe, "Spaghetti", "200g");
//				recipeService.addIngredientToRecipe(recipe, "Ground Beef", "300g");
//				recipeService.addIngredientToRecipe(recipe, "Tomato Sauce", "2 cups");
//				recipeService.addIngredientToRecipe(recipe, String.valueOf(ingredientOnion), "1 cup");
//			}
//		}
	}





}

