package com.cookingrecipes.project.presentation;

import com.cookingrecipes.project.business.*;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecipeController {

    private ModelAndView mv;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="LoginPage/UserPage/ViewRecipesForUserPage",method= RequestMethod.GET)
    public ModelAndView putRecipes()
    {
        mv=new ModelAndView("ViewRecipesForUserPage");
        List<Recipe> recipesVegan=recipeService.getVeganRecipes();
        List<Recipe> recipesNonVegan=recipeService.getNonVeganRecipes();
        mv.addObject("recipesVegan",recipesVegan);
        mv.addObject("recipesNonVegan",recipesNonVegan);
        return mv;
    }


   @PostMapping("LoginPage/UserPage/ViewRecipesForUserPage")
    public ModelAndView insertComment(@RequestParam("rt")String titleRecipe,@RequestParam("comment")String comment)
   {
        userService.addComment(titleRecipe,comment);
        return mv;
    }

    @RequestMapping(value="LoginPage/UserPage/ViewBookmarkedRecipes",method= RequestMethod.GET)
    public String putBookMarkedRecipes()
    {
        return "ViewBookmarkedRecipes";
    }

    @RequestMapping(value="LoginPage/UserPage/AddRecipePage",method= RequestMethod.GET)
    public String addRecipes()
    {
        return "AddRecipePage";
    }

    @RequestMapping(value="LoginPage/UserPage/EditAccountPage",method= RequestMethod.GET)
    public String editAccount()
    {
        return "EditAccountPage";
    }

    @RequestMapping(value="LoginPage/UserPage",method= RequestMethod.GET)
    public String theUserPage()
    {
        return "UserPage";
    }

    @PostMapping("LoginPage/UserPage/AddRecipePage")
    public String addRecipe(@RequestParam("rt")String titleRecipe,@RequestParam("comment")String comment)
    {

        return "AddRecipePage";
    }

}
