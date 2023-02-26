package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public interface RecipeService {

    Recipe newRecipe(Recipe recipe);


    Optional<Recipe> getById(Long id);
    Recipe update(Long id, Recipe recipe);

    Recipe delete(Long id);
    Map<Long, Recipe> getAllRecipe();
}










