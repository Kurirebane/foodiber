package com.team2.foodiber;


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



	}





}

