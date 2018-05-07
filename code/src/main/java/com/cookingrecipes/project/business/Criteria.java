package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Recipe;

import java.util.List;

public interface Criteria {
    public List<Recipe> meetCriteria(List<Recipe> recipes);

}
