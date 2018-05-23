package com.cookingrecipes.project.presentation.controllers;

import com.cookingrecipes.project.business.*;
import com.cookingrecipes.project.dataAccess.entities.Comment;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {

    private ModelAndView mv;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

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


   @PostMapping(value="LoginPage/UserPage/ViewRecipesForUserPage",params="Add Comment")
    public ModelAndView insertComment(@RequestParam("rt")String titleRecipe,@RequestParam("comment")String comment)
   {
        userService.addComment(titleRecipe,comment);
       List<Recipe> recipesVegan=recipeService.getVeganRecipes();
       List<Recipe> recipesNonVegan=recipeService.getNonVeganRecipes();
        mv.getModel().replace("recipesVegan",recipesVegan);
        mv.getModel().replace("recipesNonVegan",recipesNonVegan);
        return mv;
    }



    @RequestMapping(value="LoginPage/UserPage/AddRecipePage",method= RequestMethod.GET)
    public String addRecipes()
    {
        return "AddRecipePage";
    }



    @RequestMapping(value="LoginPage/UserPage",method= RequestMethod.GET)
    public String theUserPage()
    {
        return "UserPage";
    }

    @PostMapping("LoginPage/UserPage/AddRecipePage")
    public ModelAndView addRecipe(@RequestParam("recipetitle")String titleRecipe,@RequestParam("content")String content)
    {
        List<Comment> c=new ArrayList<Comment>();
        recipeService.addRecipe(new Recipe(titleRecipe,content,adminService.getAdmin().get(),c));
        return mv;
    }



}
