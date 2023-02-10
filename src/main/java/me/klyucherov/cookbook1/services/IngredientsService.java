package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredients;
import me.klyucherov.cookbook1.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class IngredientsService {
    private Map<Long, Ingredients> ingredientsMap = new HashMap<>();

    private Long generatedId = 1L;


    public Ingredients createIngredients(Ingredients ingredients) {
        ingredientsMap.put(generatedId, ingredients);
        generatedId++;
        return ingredients;
    }
    public Ingredients getIngredientsById(Long recipeId) {
        return ingredientsMap.get(generatedId);
    }

    public Ingredients updateIngredients(Long recipeId, Ingredients ingredients) {
        ingredientsMap.put(recipeId, ingredients);
        return ingredients;
    }

}
