package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.entities.User;
import com.cookingrecipes.project.dataAccess.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

   /* void bookmarkRecipe(Recipe recipe,User user)
    {
        List<Recipe> recipesBookmarked=user.getRecipes();
        recipesBookmarked.add(recipe);
        userRepository.save(user);

    }*/

}
