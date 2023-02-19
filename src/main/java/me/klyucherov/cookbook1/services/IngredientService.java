package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;


public interface IngredientService {

    Ingredient newRecipe(Ingredient ingredient);


    Optional<Ingredient> getById(Long id);

    Ingredient update(Long id, Ingredient ingredient);

    Ingredient delete(Long id);
    Map<Long, Ingredient> getAllIngredient();

}
