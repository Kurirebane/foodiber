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

		Recipe recipe1 = new Recipe();
		recipe1.setName("Pasta bolognese");
		recipe1.setRecipeCategory(RecipeCategory.MAIN_COURSE);
		recipe1.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.save(recipe1);

		Recipe recipe2 = new Recipe();
		recipe2.setName("Chia seed pancakes with greek yoghurt");
		recipe2.setRecipeCategory(RecipeCategory.BREAKFAST);
		recipe2.setCookingTime(CookingTime.MEDIUM_15MIN);
		recipeRepository.save(recipe2);

		Recipe recipe3 = new Recipe();
		recipe3.setName("Oat porridge with fresh berries and honey drizzle");
		recipe3.setRecipeCategory(RecipeCategory.BREAKFAST);
		recipe3.setCookingTime(CookingTime.FAST_5MIN);
		recipeRepository.save(recipe3);

		Recipe recipe4 = new Recipe();
		recipe4.setName("Creamy roasted pumpkin soup");
		recipe4.setRecipeCategory(RecipeCategory.SOUP);
		recipe4.setCookingTime(CookingTime.SLOW_30MIN);
		Recipe savedPumpkinSoup = recipeRepository.save(recipe4);


		Recipe recipe5 = new Recipe();
		recipe5.setName("Avocado toast");
		recipe5.setRecipeCategory(RecipeCategory.BREAKFAST);
		recipe5.setCookingTime(CookingTime.FAST_5MIN);
		Recipe savedAvocadoToast = recipeRepository.save(recipe5);

		Ingredient ingredients = new Ingredient();
		ingredients.setItem("carrot");
		ingredients.setGlutenFree(true);
		ingredients.setLactoseFree(true);
		Ingredient savedIngredientsCarrot = ingredientsRepository.save(ingredients);

		RecipeIngredients recipeIngredients = new RecipeIngredients();
		recipeIngredients.setIngredient(savedIngredientsCarrot);
		recipeIngredients.setRecipe(savedPumpkinSoup);
		recipeIngredients.setQuantity("3");
		recipeIngredientsRepository.save(recipeIngredients);


		Recipe recipe6 = new Recipe();
		recipe6.setName("Chickpea curry");
		recipe6.setRecipeCategory(RecipeCategory.VEGETARIAN);
		recipe6.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.save(recipe6);

		Recipe recipe7 = new Recipe();
		recipe7.setName("Oven roasted salmon and vegetables");
		recipe7.setRecipeCategory(RecipeCategory.MAIN_COURSE);
		recipe7.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.save(recipe7);

		Recipe recipe8 = new Recipe();
		recipe8.setName("Vegetarian lasagne");
		recipe8.setRecipeCategory(RecipeCategory.VEGETARIAN);
		recipe8.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.save(recipe8);

		Recipe recipe9 = new Recipe();
		recipe9.setName("Oven buckwheat with fried ham");
		recipe9.setRecipeCategory(RecipeCategory.MAIN_COURSE);
		recipe9.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.save(recipe9);

		Recipe recipe10 = new Recipe();
		recipe10.setName("Greek yoghurt with mango puree and crunchy granola");
		recipe10.setRecipeCategory(RecipeCategory.DESSERT);
		recipe10.setCookingTime(CookingTime.FAST_5MIN);
		recipeRepository.save(recipe10);

		Recipe recipe11 = new Recipe();
		recipe11.setName("Poor knights");
		recipe11.setRecipeCategory(RecipeCategory.DESSERT);
		recipe11.setCookingTime(CookingTime.MEDIUM_15MIN);
		recipeRepository.save(recipe11);

	}


	}

