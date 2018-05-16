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

   public User getUser(String username,String password)
   {
       return userRepository.getByUsernameAndPassword(username,password);
   }

   public void createAccount(String name,String username,String password,String email)
   {
       List<Recipe> r=new ArrayList<>();
       User user=new User.UserBuilder().setName(name).setUsername(username).setPassw(password).setRecipes(r).setEmail(email).build();

       userRepository.save(user);
   }

   public void addComment(String recipeTitle,String comment)
   {
     Recipe myRecipe=recipeService.findRecipe(recipeTitle);
     Comment comm=new Comment(comment,myRecipe);
     commentService.addComment(comm);
   }

   public void updateAccount(User u,String name,String username,String password,String email)
   {
       u.setName(name);
       u.setUsername(username);
       u.setPassw(password);
       u.setEmail(email);
       userRepository.save(u);
   }

   public List<User> getAllUsers()
   {
       return userRepository.findAll();
   }
}