package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Admin;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    RecipeService recipeService;

    @Autowired
    AdminRepository adminRepository;

    public void blockUser()
    {

    }

    public void deleteRecipe(Recipe recipe)
    {
        recipeService.deleteRecipe(recipe);
    }

    /*public boolean verifyIfAdmin(String username,String password)
    {
        boolean verify=false;
        if(adminRepository.verifyIfAdmin(username,password)==true)
            verify=true;
        return verify;
    }*/
    public Optional<Admin> getAdmin()
    {
        return adminRepository.findById(1);
    }
}
