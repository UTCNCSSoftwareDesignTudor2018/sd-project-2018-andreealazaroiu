package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Recipe;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaVegan implements Criteria {
    @Override
    public List<Recipe> meetCriteria(List<Recipe> recipes) {

        return recipes.stream()
                .filter(t->t.getTitle().contains("Vegan"))
                .collect(Collectors.toList());

    }
}
