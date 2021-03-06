package com.cookingrecipes.project.dataAccess.repositories;

import com.cookingrecipes.project.dataAccess.entities.Comment;
import com.cookingrecipes.project.dataAccess.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {


     Recipe findByTitle(@Param("nr")String nameRecipe);

}
