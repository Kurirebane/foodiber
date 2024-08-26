package com.team2.foodiber.data;

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
        Recipe pumpkinSoup = recipeService.createRecipe("Creamy roasted pumpkin soup", RecipeCategory.SOUP, CookingTime.SLOW_30MIN, "Heat oil in a large saucepan over medium heat. Add onion and cook for 2-3 minutes until soft. Add garlic and vegetables, then toss to coat. Add stock, then bring to the boil. Reduce heat to low, cover and cook for 25 minutes or until the vegetables are tender. Cool slightly. In batches, transfer to a blender and whiz until smooth. Return soup to the saucepan and place over low heat. Stir in cream, then season. To serve, ladle into bowls and top with seeds and parsley, then drizzle with extra oil. ");
        Recipe pastaBolognese = recipeService.createRecipe("Pasta Bolognese", RecipeCategory.MAIN_COURSE, CookingTime.SLOW_30MIN, "Heat a large saucepan over a medium heat. Add a tablespoon of olive oil and once hot add the beef mince and a pinch of salt and pepper. Cook the mince until well browned over a medium-high heat (be careful not to burn the mince. It just needs to be a dark brown colour). Once browned, transfer the mince to a bowl and set aside. Add another tablespoon of oil to the saucepan you browned the mince in and turn the heat to medium. Add the onions and a pinch of salt and fry gently for 5-6 minutes, or until softened and translucent. Add the garlic and cook for another 2 minutes. Add the grated carrot then pour the mince and any juices in the bowl back into the saucepan. Add the tomatoes to the pan and stir well to mix. Pour in the stock, bring to a simmer and then reduce the temperature to simmer gently for 45 minutes, or until the sauce is thick and rich. Taste and adjust the seasoning as necessary. When ready to cook the spaghetti, heat a large saucepan of water and add a pinch of salt. Cook according to the packet instructions. Once the spaghetti is cooked through, drain and add to the pan with the bolognese sauce. Mix well and serve.");
        Recipe pancakes = recipeService.createRecipe("Chia seed pancakes with greek yoghurt", RecipeCategory.BREAKFAST, CookingTime.MEDIUM_15MIN, "In a bowl whisk together eggs and sugar. Add milk, flour and a pinch of salt. Mix well and add chia seeds. Leave for 10 minutes and then cook preferred size of pancakes on medium heat flipping half-way through. Transfer to a plate and top with greek yoghurt and peanut butter");
        Recipe oatPorridge = recipeService.createRecipe("Oat porridge with fresh berries and honey drizzle", RecipeCategory.BREAKFAST, CookingTime.FAST_5MIN, "");
        Recipe avocadoToast = recipeService.createRecipe("Avocado toast", RecipeCategory.BREAKFAST, CookingTime.FAST_5MIN, "Toast the bread to your desired level of crunchiness. Slice the avocado and remove the pit. Place half of avocado onto one slice of bread and the other half onto another. Mash with a fork. Cut the lemon in half and squeeze lemon juice onto avocado. Boil the egg and after peeling cut into little cubes to place on avocado. Top with salt and pepper to your taste.");
        Recipe chickpeaCurry = recipeService.createRecipe("Chickpea curry", RecipeCategory.VEGETARIAN, CookingTime.SLOW_30MIN, "");
        Recipe ovenroastedSalmon = recipeService.createRecipe("Oven roasted salmon with vegetables", RecipeCategory.MAIN_COURSE, CookingTime.SLOW_30MIN, "");
        Recipe zucchiniLasagne = recipeService.createRecipe("Zucchini lasagne", RecipeCategory.VEGETARIAN, CookingTime.SLOW_30MIN, "");
        Recipe ovenBuckwheat = recipeService.createRecipe("Oven baked buckwheat with fried ham", RecipeCategory.MAIN_COURSE, CookingTime.SLOW_30MIN, "");
        Recipe greekYoghurtGranola = recipeService.createRecipe("Greek yoghurt with mango puree and crunchy granola", RecipeCategory.DESSERT, CookingTime.FAST_5MIN, "");
        Recipe poorKnights = recipeService.createRecipe("Poor knights", RecipeCategory.DESSERT, CookingTime.FAST_5MIN, "");
        Recipe peaAndThymeSoup = recipeService.createRecipe("Potato and pea soup with fresh thyme", RecipeCategory.SOUP, CookingTime.SLOW_30MIN, "");


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
        Ingredient mincedMeat = recipeService.createIngredient("minced meat", true, true);
        Ingredient sugar = recipeService.createIngredient("sugar", true, true);
        Ingredient peanutButter = recipeService.createIngredient("peanut butter", true, true);
        Ingredient butter = recipeService.createIngredient("butter", true, true);
        Ingredient lentils = recipeService.createIngredient("lentils", true, true);
        Ingredient cheddarCheese = recipeService.createIngredient("cheddar cheese", true, false);
        Ingredient oatCream = recipeService.createIngredient("oat cream", true, true);
        Ingredient water = recipeService.createIngredient("water", true, true);
        Ingredient cinnamon = recipeService.createIngredient("cinnamon", true, true);

        // Add ingredients to the recipe

        // PUMPKINSOUP
        recipeService.addIngredientToRecipe(pumpkinSoup, carrot, "gr", 60);
        recipeService.addIngredientToRecipe(pumpkinSoup, oliveOil, "tbsp", 3);
        recipeService.addIngredientToRecipe(pumpkinSoup, pumpkin, "gr", 200);
        recipeService.addIngredientToRecipe(pumpkinSoup, potato, "gr", 150);
        recipeService.addIngredientToRecipe(pumpkinSoup, garlic, "glove", 1);
        recipeService.addIngredientToRecipe(pumpkinSoup, onion, "30gr", 30);
        recipeService.addIngredientToRecipe(pumpkinSoup, leek, "gr", 50);
        recipeService.addIngredientToRecipe(pumpkinSoup, stock, "ml", 100);
        recipeService.addIngredientToRecipe(pumpkinSoup, coconutCream, "gr", 40);
        recipeService.addIngredientToRecipe(pumpkinSoup, pumpkinSeeds, "to taste", 0.1);
        recipeService.addIngredientToRecipe(pumpkinSoup, parsley, "to taste", 0.1);

        // PASTA BOLOGNESE
        recipeService.addIngredientToRecipe(pastaBolognese , oliveOil, "tbsp", 1);
        recipeService.addIngredientToRecipe(pastaBolognese , mincedMeat, "gr", 100);
        recipeService.addIngredientToRecipe(pastaBolognese , onion, "gr", 10);
        recipeService.addIngredientToRecipe(pastaBolognese , garlic, "gr", 5);
        recipeService.addIngredientToRecipe(pastaBolognese , carrot, "gr", 25);
        recipeService.addIngredientToRecipe(pastaBolognese , tomatoSauce, "gr", 200);
        recipeService.addIngredientToRecipe(pastaBolognese , stock, "ml", 100);
        recipeService.addIngredientToRecipe(pastaBolognese , pasta, "gr", 100);
        recipeService.addIngredientToRecipe(pastaBolognese , salt, "to taste", 0.1);
        recipeService.addIngredientToRecipe(pastaBolognese , pepper, "to taste", 0.1);

        // PANCAKES
        recipeService.addIngredientToRecipe(pancakes, egg, "egg/eggs", 1);
        recipeService.addIngredientToRecipe(pancakes, sugar, "gr", 10);
        recipeService.addIngredientToRecipe(pancakes, wholeWheatFlour, "gr", 50);
        recipeService.addIngredientToRecipe(pancakes, milk, "ml", 50);
        recipeService.addIngredientToRecipe(pancakes, salt, "pinch", 1);
        recipeService.addIngredientToRecipe(pancakes, chiaSeeds, "tsp", 1);
        recipeService.addIngredientToRecipe(pancakes, greekYoghurt, "to taste", 0.1);
        recipeService.addIngredientToRecipe(pancakes, peanutButter, "to taste", 0.1);

        //OAT PORRIDGE
        recipeService.addIngredientToRecipe(oatPorridge, milk, "ml", 100);
        recipeService.addIngredientToRecipe(oatPorridge, oats, "gr", 30);
        recipeService.addIngredientToRecipe(oatPorridge, chiaSeeds, "to taste", 0.1);
        recipeService.addIngredientToRecipe(oatPorridge, honey, "gr", 10);
        recipeService.addIngredientToRecipe(oatPorridge, raspberries, "gr", 50);
        recipeService.addIngredientToRecipe(oatPorridge, blueberries, "gr", 50);
        recipeService.addIngredientToRecipe(oatPorridge, butter, "gr", 15);

        //AVOCADO TOAST
        recipeService.addIngredientToRecipe(avocadoToast, bread, "slices", 2);
        recipeService.addIngredientToRecipe(avocadoToast, avocado, "avocado", 1);
        recipeService.addIngredientToRecipe(avocadoToast, egg, "egg/eggs", 1);
        recipeService.addIngredientToRecipe(avocadoToast, lemon, "to taste", 0.1);
        recipeService.addIngredientToRecipe(avocadoToast, pepper, "to taste", 0.1);
        recipeService.addIngredientToRecipe(avocadoToast, salt, "to taste", 0.1);

        //CHICKPEA CURRY
        recipeService.addIngredientToRecipe(chickpeaCurry, chickpeas, "gr", 100);
        recipeService.addIngredientToRecipe(chickpeaCurry, coconutCream, "ml", 100);
        recipeService.addIngredientToRecipe(chickpeaCurry, butter, "gr", 10);
        recipeService.addIngredientToRecipe(chickpeaCurry, carrot, "gr", 100);
        recipeService.addIngredientToRecipe(chickpeaCurry, lentils, "gr", 80);
        recipeService.addIngredientToRecipe(chickpeaCurry, salt, "to taste", 0.1);
        recipeService.addIngredientToRecipe(chickpeaCurry, pepper, "to taste", 0.1);
        recipeService.addIngredientToRecipe(chickpeaCurry, stock, "ml", 200);

        //OVENROASTED SALMON
        recipeService.addIngredientToRecipe(ovenroastedSalmon, salmon, "gr", 150);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, lemon, "to taste", 0.1);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, dill, "to taste", 0.1);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, beetroot, "gr", 100);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, carrot, "gr", 100);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, potato, "gr", 100);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, asparagus, "gr", 75);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, salt, "to taste", 0.1);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, pepper, "to taste", 0.1);
        recipeService.addIngredientToRecipe(ovenroastedSalmon, oliveOil, "gr", 15);

        //ZUCCHINI LASAGNE
        recipeService.addIngredientToRecipe(zucchiniLasagne, zucchini, "gr", 400);
        recipeService.addIngredientToRecipe(zucchiniLasagne, oatCream, "ml", 400);
        recipeService.addIngredientToRecipe(zucchiniLasagne, salt, "to taste", 0.1);
        recipeService.addIngredientToRecipe(zucchiniLasagne, pepper, "to taste", 0.1);
        recipeService.addIngredientToRecipe(zucchiniLasagne, tofu, "gr", 200);
        recipeService.addIngredientToRecipe(zucchiniLasagne, parsley, "to taste", 0.1);
        recipeService.addIngredientToRecipe(zucchiniLasagne, tomatoSauce, "gr", 200);

        //OVEN BUCKWHEAT WITH FRIED HAM
        recipeService.addIngredientToRecipe(ovenBuckwheat, buckwheat, "100gr", 100);
        recipeService.addIngredientToRecipe(ovenBuckwheat, butter, "to taste", 0.1);
        recipeService.addIngredientToRecipe(ovenBuckwheat, ham, "75gr", 75);
        recipeService.addIngredientToRecipe(ovenBuckwheat, carrot, "50gr", 50);
        recipeService.addIngredientToRecipe(ovenBuckwheat, stock, "200ml", 200);
        recipeService.addIngredientToRecipe(ovenBuckwheat, peas, "50gr", 50);
        recipeService.addIngredientToRecipe(ovenBuckwheat, water, "150ml", 150);

        //GREEK YOGHURT GRANOLA
        recipeService.addIngredientToRecipe(greekYoghurtGranola, granola, "gr", 60);
        recipeService.addIngredientToRecipe(greekYoghurtGranola, greekYoghurt, "gr", 200);
        recipeService.addIngredientToRecipe(greekYoghurtGranola, mangoPuree, "gr", 50);
        recipeService.addIngredientToRecipe(greekYoghurtGranola, chiaSeeds, "gr", 10);

        //POOR KNIGHTS
        recipeService.addIngredientToRecipe(poorKnights, bread, "slices", 3);
        recipeService.addIngredientToRecipe(poorKnights, egg, "egg/eggs", 1);
        recipeService.addIngredientToRecipe(poorKnights, milk, "ml", 30);
        recipeService.addIngredientToRecipe(poorKnights, honey, "gr", 10);
        recipeService.addIngredientToRecipe(poorKnights, sugar, "gr", 10);
        recipeService.addIngredientToRecipe(poorKnights, cinnamon, "to taste", 0.1);

        //PEA AND THYME SOUP
        recipeService.addIngredientToRecipe(peaAndThymeSoup, peas, "gr", 150);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, potato, "gr", 150);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, butter, "gr", 20);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, salt, "to taste", 0.1);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, pepper, "to taste", 0.1);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, thyme, "handful", 1);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, cream, "ml", 100);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, garlic, "gr", 10);
        recipeService.addIngredientToRecipe(peaAndThymeSoup, onion, "gr", 20);
    }


}
