package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Comment;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.entities.User;
import com.cookingrecipes.project.dataAccess.repositories.RecipeRepository;
import com.cookingrecipes.project.dataAccess.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeService recipeService;

    @Autowired
    CommentService commentService;

   /* void bookmarkRecipe(Recipe recipe,User user)
    {
        List<Recipe> recipesBookmarked=user.getRecipes();
        recipesBookmarked.add(recipe);
        userRepository.save(user);

    }*/
  public void unbookmark(Recipe recipe)
   {

   }

  public  boolean verifyIfUser(String username,String password)
   {
       boolean verify=false;
       if(userRepository.getByUsernameAndPassword(username,password)!=null)
           verify=true;
       return verify;
   }

   public void createAccount(String name,String username,String password)
   {
       List<Recipe> r=new ArrayList<>();
       userRepository.save(new User(name,username,password,r));
   }

   public void addComment(String recipeTitle,String comment)
   {
     Recipe myRecipe=recipeService.findRecipe(recipeTitle);
     Comment comm=new Comment(comment,myRecipe);
     commentService.addComment(comm);
   }
}