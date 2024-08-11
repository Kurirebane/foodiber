package com.team2.foodiber.controller;

import com.team2.foodiber.model.Recipe;
import com.team2.foodiber.model.RecipeCategory;
import com.team2.foodiber.model.User;
import com.team2.foodiber.service.RecipeService;
import com.team2.foodiber.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    // Create an API with path /search-recipe that shows the list of recipes

    private final UserService userService;
    private final RecipeService recipeService;


    @GetMapping(path = "/search-recipe")
    public String getAllRecipes(final ModelMap modelMap) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        modelMap.addAttribute("recipes", recipes);
        return "search-recipes";
    }

    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @GetMapping(path = "/select-category")
    public String getAllCategories() {

        return "select-category";
    }


    @GetMapping("/category")
    public String getCategoryPage(@RequestParam(name = "name") RecipeCategory recipeCategory, ModelMap model) {
        List<Recipe> filteredRecipes = recipeService.getRecipesByCategory(recipeCategory);
        model.addAttribute("recipes", filteredRecipes);
        model.addAttribute("categoryName", recipeCategory);
        return "category";
    }

    @GetMapping("/recipe/details")
    public String getRecipeDetails(@RequestParam(name = "id") Long recipeId, Model model) {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        if (recipe == null) {
            return "/select-category";  // Handle the error properly
        }
        model.addAttribute("recipe", recipe);
        return "recipe-details";
    }



    @PostMapping("create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/")
//    public String showIndexPage() {
//        return "index";
//    }
//
//    @PostMapping("/login")
//    public String loginFormHandlerer(@RequestParam("username") String username,
//                                     @RequestParam("password") String password,
//                                     Model model) {
//        if (userService.isValidUser(username,password)) {
//            return "redirect:/home";
//        }
//        model.addAttribute("error", "Invalid username or password");
//        return "login";
//    }
}


//    @GetMapping(path = )







