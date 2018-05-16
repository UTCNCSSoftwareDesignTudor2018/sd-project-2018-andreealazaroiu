package com.cookingrecipes.project.presentation;

import com.cookingrecipes.project.business.AdminService;
import com.cookingrecipes.project.business.RecipeService;
import com.cookingrecipes.project.business.UserService;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private ModelAndView mv;
    private ModelAndView m;
    private ModelAndView ma;

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    AdminService adminService;

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
        ModelAndView ml=new ModelAndView("LoginPage");


        if(userService.verifyIfUser(username, password))
            return mv;
        else if(adminService.verifyIfAdmin(username,password))
            return ma;
        else
            return ml;
    }

    @RequestMapping(value="LoginPage/UserPage/EditAccountPage",method= RequestMethod.GET)
    public ModelAndView editAccount()
    {
        m=new ModelAndView("EditAccountPage");
        m.addObject("tu",mv.getModel().get("tu"));

        return m;
    }

    @PostMapping("LoginPage/UserPage/EditAccountPage")
    public ModelAndView editAccountOk(@RequestParam("putname")String name,
                                @RequestParam("putusername")String username,
                                @RequestParam("putpassw")String passw,
                                @RequestParam("putemail")String email)
    {
        userService.updateAccount((User)mv.getModel().get("tu"),name,username,passw,email);
        return m;
    }
}
