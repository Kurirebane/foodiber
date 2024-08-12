package com.team2.foodiber.config;

import com.team2.foodiber.model.CookingTime;
import com.team2.foodiber.model.Ingredient;
import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import com.team2.foodiber.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RecipeService recipeService;
    @Override
    public void run(String... args) throws Exception {

        // Create a recipe
        Recipe pumpkinSoup = recipeService.createRecipe("Creamy roasted pumpkin soup", RecipeCategory.SOUP, CookingTime.SLOW_30MIN);
        Recipe pastaBolognese = recipeService.createRecipe("Pasta Bolognese", RecipeCategory.MAIN_COURSE, CookingTime.SLOW_30MIN);
        Recipe pancakes = recipeService.createRecipe("Chia seed pancakes with greek yoghurt", RecipeCategory.BREAKFAST, CookingTime.MEDIUM_15MIN);
        Recipe oatPorridge = recipeService.createRecipe("Oat porridge with fresh berries and honey drizzle", RecipeCategory.BREAKFAST, CookingTime.FAST_5MIN);
        Recipe avocadoToast = recipeService.createRecipe("Avocado toast", RecipeCategory.BREAKFAST, CookingTime.FAST_5MIN);
        Recipe chickpeaCurry = recipeService.createRecipe("Chickpea curry", RecipeCategory.VEGETARIAN, CookingTime.SLOW_30MIN);
        Recipe ovenroastedSalmon = recipeService.createRecipe("Oven roasted salmon with vegetables", RecipeCategory.MAIN_COURSE, CookingTime.SLOW_30MIN);
        Recipe zucchiniLasagne = recipeService.createRecipe("Zucchini lasagne", RecipeCategory.VEGETARIAN, CookingTime.SLOW_30MIN);
        Recipe ovenBuckwheat = recipeService.createRecipe("Oven baked buckwheat with fried ham", RecipeCategory.MAIN_COURSE, CookingTime.SLOW_30MIN);
        Recipe greekYoghurtGranola = recipeService.createRecipe("Greek yoghurt with mango puree and crunchy granola", RecipeCategory.DESSERT, CookingTime.FAST_5MIN);
        Recipe poorKnights = recipeService.createRecipe("Poor knights", RecipeCategory.DESSERT, CookingTime.FAST_5MIN);
        Recipe peaAndThymeSoup = recipeService.createRecipe("Potato and pea soup with fresh thyme", RecipeCategory.SOUP, CookingTime.SLOW_30MIN);


        // Create ingredients
        Ingredient carrot = recipeService.createIngredient("carrot", true, true);
        Ingredient oliveOil = recipeService.createIngredient("olive oil", true, true);
        Ingredient potato = recipeService.createIngredient("potato", true, true);
        Ingredient pumpkin = recipeService.createIngredient("pumpkin", true, true);
        Ingredient onion = recipeService.createIngredient("onion", true, true);
        Ingredient cream = recipeService.createIngredient("20% coffee cream", true, false);
        Ingredient garlic = recipeService.createIngredient("garlic", true, true);
        Ingredient leek = recipeService.createIngredient("leek", true, true);
        Ingredient stock = recipeService.createIngredient("chicken stock", true, true);
        Ingredient pasta = recipeService.createIngredient("pasta", false, true);
        Ingredient tomatoSauce = recipeService.createIngredient("tomato sauce", true, true);
        Ingredient greekYoghurt = recipeService.createIngredient("greek yoghurt", true, false);
        Ingredient peas = recipeService.createIngredient("green peas", true, true);
        Ingredient zucchini = recipeService.createIngredient("zucchini", true, true);
        Ingredient buckwheat = recipeService.createIngredient("buckwheat", true, true);
        Ingredient ham = recipeService.createIngredient("ham", true, true);
        Ingredient mangoPuree = recipeService.createIngredient("mango puree", true, true);
        Ingredient bread = recipeService.createIngredient("white bread", false, true);
        Ingredient thyme = recipeService.createIngredient("fresh thyme", true, true);
        Ingredient granola = recipeService.createIngredient("crunchy granola", true, true);
        Ingredient oats = recipeService.createIngredient("oats", true, true);
        Ingredient chiaSeeds = recipeService.createIngredient("chia seeds", true, true);
        Ingredient tofu = recipeService.createIngredient("tofu", true, true);
        Ingredient chickpeas = recipeService.createIngredient("chickpeas", true, true);
        Ingredient coconutCream = recipeService.createIngredient("coconut cream", true, true);
        Ingredient salmon = recipeService.createIngredient("salmon", true, true);
        Ingredient beetroot = recipeService.createIngredient("beetroot", true, true);
        Ingredient asparagus = recipeService.createIngredient("asparagus", true, true);
        Ingredient lemon = recipeService.createIngredient("lemon", true, true);
        Ingredient avocado = recipeService.createIngredient("avocado", true, true);
        Ingredient milk = recipeService.createIngredient("milk", true, false);
        Ingredient honey = recipeService.createIngredient("honey", true, true);
        Ingredient raspberries = recipeService.createIngredient("raspberries", true, true);
        Ingredient blueberries = recipeService.createIngredient("blueberries", true, true);
        Ingredient wholeWheatFlour = recipeService.createIngredient("whole wheat flour", false, true);
        Ingredient egg = recipeService.createIngredient("egg", true, true);
        Ingredient curry = recipeService.createIngredient("curry", true, true);
        Ingredient pepper = recipeService.createIngredient("black pepper", true, true);
        Ingredient salt = recipeService.createIngredient("salt", true, true);
        Ingredient dill = recipeService.createIngredient("dill", true, true);
        Ingredient parsley = recipeService.createIngredient("parsley", true, true);
        Ingredient pumpkinSeeds = recipeService.createIngredient("pumpkin seeds", true, true);



        // Add ingredients to the recipe

        // PUMPKINSOUP
        recipeService.addIngredientToRecipe(pumpkinSoup, carrot, "60 gr");
        recipeService.addIngredientToRecipe(pumpkinSoup, oliveOil, "3 tablespoons");
        recipeService.addIngredientToRecipe(pumpkinSoup, pumpkin, "200 gr");
        recipeService.addIngredientToRecipe(pumpkinSoup, potato, "150gr");
        recipeService.addIngredientToRecipe(pumpkinSoup, garlic, "1 glove");
        recipeService.addIngredientToRecipe(pumpkinSoup, onion, "30gr");
        recipeService.addIngredientToRecipe(pumpkinSoup, leek, "50gr");
        recipeService.addIngredientToRecipe(pumpkinSoup, stock, "100ml");
        recipeService.addIngredientToRecipe(pumpkinSoup, coconutCream, "40gr");
        recipeService.addIngredientToRecipe(pumpkinSoup, leek, "50gr");
        recipeService.addIngredientToRecipe(pumpkinSoup, pumpkinSeeds, "to taste");
        recipeService.addIngredientToRecipe(pumpkinSoup, parsley, "to taste");







        // You can repeat the process to add more recipes and ingredients
    }


}
