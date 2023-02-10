package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredients;
import me.klyucherov.cookbook1.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {
    private Map<Long, Recipe> recipeMap = new HashMap<>();

    private Long generatedId = 1L;


    public Recipe createRecipe(Recipe recipe) {
        recipeMap.put(generatedId, recipe);
        generatedId++;
        return recipe;
    }
    public Recipe getRecipeById(Long recipeId) {
        return recipeMap.get(recipeId);
    }

    public Recipe updateRecipe(Long recipeId, Recipe recipe) {
        recipeMap.put(recipeId, recipe);
        return recipe;
    }
}










