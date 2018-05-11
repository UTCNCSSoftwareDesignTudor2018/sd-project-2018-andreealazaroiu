package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    RecipeService recipeService;

    @Autowired
    AdminService adminService;

    public void blockUser()
    {

    }

    public void deleteRecipe(Recipe recipe)
    {
        recipeService.deleteRecipe(recipe);
    }

    public boolean verifyIfAdmin(String username,String password)
    {
        boolean verify=false;
        if(adminService.verifyIfAdmin(username,password)==true)
            verify=true;
        return verify;
    }
}
