package com.cookingrecipes.project.presentation;

import com.cookingrecipes.project.business.Criteria;
import com.cookingrecipes.project.business.CriteriaVegan;
import com.cookingrecipes.project.business.RecipeService;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecipeController {

    private ModelAndView mv;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value="LoginPage/UserPage/ViewRecipesForUserPage",method= RequestMethod.GET)
    public ModelAndView putRecipes()
    {
        mv=new ModelAndView("ViewRecipesForUserPage");
        Criteria c=new CriteriaVegan();
        List<Recipe> recipes=recipeService.getAllRecipes();
        List<Recipe> recipesVegan=c.meetCriteria(recipes);
        mv.addObject("recipesVegan",recipesVegan);
        return mv;
    }


   @PostMapping("ViewRecipesForUserPage")
    public String getAllRecipes()
    {
        return "ViewRecipesForUserPage";
    }
}
