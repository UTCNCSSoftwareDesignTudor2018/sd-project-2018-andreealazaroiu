package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public void addRecipe(Recipe recipe)
    {
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Recipe recipe)
    {
        recipeRepository.delete(recipe);
    }

    public Recipe findRecipe(String nameRecipe)
    {
        return recipeRepository.findByTitle(nameRecipe);
    }

   public List<Recipe> getVeganRecipes()
   {
       List<Recipe> recipes=this.getAllRecipes();
       Criteria c=new CriteriaVegan();
       return c.meetCriteria(recipes);
   }
    public List<Recipe> getNonVeganRecipes()
    {
        List<Recipe> recipes=this.getAllRecipes();
        Criteria c=new CriteriaNonVegan();
        return c.meetCriteria(recipes);
    }

    public List<Recipe> getAllRecipes()
    {
        return recipeRepository.findAll();
    }
}