package com.cookingrecipes.project.dataAccess.repositories;

import com.cookingrecipes.project.dataAccess.entities.Recipe;
import com.cookingrecipes.project.dataAccess.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    // List<Recipe> getByRecipes();

     @Query("Select u from User u where u.username=:us and u.passw=:up")
     User getByUsernameAndPassword(@Param("us")String username,@Param("up")String password);

     @Query("Select u from User u where u.name=:un")
     User getByName(@Param("un")String name);
}
