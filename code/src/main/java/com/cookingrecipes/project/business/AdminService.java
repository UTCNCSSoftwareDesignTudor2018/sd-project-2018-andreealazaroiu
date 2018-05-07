package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    RecipeService recipeService;

    public void blockUser()
    {

    }

    public void deleteRecipe(Recipe recipe)
    {
        recipeService.deleteRecipe(recipe);
    }
}
