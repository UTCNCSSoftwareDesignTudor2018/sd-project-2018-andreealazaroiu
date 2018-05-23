package com.cookingrecipes.project.presentation.controllers;

import com.cookingrecipes.project.business.AdminService;
import com.cookingrecipes.project.business.RecipeService;
import com.cookingrecipes.project.business.UserService;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.entities.User;
import com.cookingrecipes.project.dataAccess.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private ModelAndView mv;
    private ModelAndView m;
    private ModelAndView ma;
    private ModelAndView mb;
    private ModelAndView ml;
    private User user;

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    AdminService adminService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value={"UserPage","AdminPage"})
    public ModelAndView userLogin(@RequestParam("lu") String username, @RequestParam("lp") String password)
    {
        mv=new ModelAndView("UserPage");
        User theuser=userService.getUser(username,password);
        mv.addObject("tu",theuser);
        ma=new ModelAndView("AdminPage");
        List<Recipe> recipes=recipeService.getAllRecipes();
        ma.addObject("recipes",recipes);
        List<User>users=userService.getAllUsers();
        ma.addObject("users",users);
        ml=new ModelAndView("LoginPage");
        user=(User) mv.getModel().get("tu");

        if(userService.verifyIfUser(username, password))
            return mv;
        else if(adminService.verifyIfAdmin(username,password))
            return ma;
        else
            return ml;
    }
    @RequestMapping(value="LoginPage/UserPage/ViewBookmarkedRecipes",method= RequestMethod.GET)
    public ModelAndView putBookMarkedRecipes()
    {
        mb=new ModelAndView("ViewBookmarkedRecipes");
        List<Recipe> bm=user.getRecipes();
        mb.addObject("recipesbook",bm);
        return mb;
    }

    @PostMapping(value = "LoginPage/UserPage/ViewBookmarkedRecipes",params = "unbookmark")
    public ModelAndView remBR(@RequestParam("rtitle")String rt)
    {
        Recipe recipet=recipeService.findRecipe(rt);
        userService.unbookmark(recipet,user);
        mb.getModel().replace("recipesbook",user.getRecipes());
        return mb;
    }

    @PostMapping(value="LoginPage/UserPage/ViewRecipesForUserPage",params="bookmark")
    public ModelAndView addBR(@RequestParam("recipetitle")String rt)
    {
        Recipe recipe=recipeService.findRecipe(rt);
        userService.bookmark(recipe,user);
        mb.getModel().replace("recipesbook",user.getRecipes());
        return mb;
    }

    @RequestMapping(value="LoginPage/UserPage/EditAccountPage",method= RequestMethod.GET)
    public ModelAndView editAccount()
    {
        m=new ModelAndView("EditAccountPage");
        m.addObject("tu",user);
        m.addObject("user",new User());
        return m;
    }

    @PostMapping("LoginPage/UserPage/EditAccountPage")
    public ModelAndView editAccountOk(@ModelAttribute("user")User user,@RequestParam("putname")String name,
                                @RequestParam("putusername")String username,
                                @RequestParam("putpassw")String passw,
                                @RequestParam("putemail")String email)
    {
        userService.updateAccount((User)mv.getModel().get("tu"),name,username,passw,email);
        return m;
    }

    @PostMapping(value = "AdminPage",params = "DelUser")
    public ModelAndView deleteUser(@RequestParam("nameuser")String nameuser )
    {
        User u=userService.getUserByName(nameuser);
        userService.deleteUser(u);
        ma.getModel().replace("users", userService.getAllUsers());
        return ma;
    }
    @PostMapping(value = "AdminPage",params = "DelRecipe")
    public ModelAndView deleteRecipe(@RequestParam("namerecipe")String namerecipe )
    {
        Recipe r=recipeService.findRecipe(namerecipe);
        adminService.deleteRecipe(r);
        ma.getModel().replace("recipes",recipeService.getAllRecipes());
        return ma;
    }


}
