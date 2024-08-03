package com.team2.foodiber;

import com.team2.foodiber.model.CookingTime;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
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


	public static void main(String[] args) {
		SpringApplication.run(FoodiberApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Recipe recipe1 = new Recipe();
		recipe1.setName("Pasta bolognese");
		recipe1.setRecipeCategory(RecipeCategory.MAIN_COURSE);
		recipe1.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.saveAndFlush(recipe1);

		Recipe recipe2 = new Recipe();
		recipe2.setName("Chia seed pancakes with greek yoghurt");
		recipe2.setRecipeCategory(RecipeCategory.BREAKFAST);
		recipe2.setCookingTime(CookingTime.MEDIUM_15MIN);
		recipeRepository.saveAndFlush(recipe2);

		Recipe recipe3 = new Recipe();
		recipe3.setName("Oat porridge with fresh berries and honey drizzle");
		recipe3.setRecipeCategory(RecipeCategory.BREAKFAST);
		recipe3.setCookingTime(CookingTime.FAST_5MIN);
		recipeRepository.saveAndFlush(recipe3);

		Recipe recipe4 = new Recipe();
		recipe4.setName("Creamy roasted pumpkin soup");
		recipe4.setRecipeCategory(RecipeCategory.SOUP);
		recipe4.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.saveAndFlush(recipe4);

		Recipe recipe5 = new Recipe();
		recipe5.setName("Avocado toast");
		recipe5.setRecipeCategory(RecipeCategory.BREAKFAST);
		recipe5.setCookingTime(CookingTime.FAST_5MIN);
		recipeRepository.saveAndFlush(recipe5);

		Recipe recipe6 = new Recipe();
		recipe6.setName("Chickpea curry");
		recipe6.setRecipeCategory(RecipeCategory.VEGETARIAN);
		recipe6.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.saveAndFlush(recipe6);

		Recipe recipe7 = new Recipe();
		recipe7.setName("Oven roasted salmon and vegetables");
		recipe7.setRecipeCategory(RecipeCategory.SOUP);
		recipe7.setCookingTime(CookingTime.SLOW_30MIN);
		recipeRepository.saveAndFlush(recipe7);
	}


}
