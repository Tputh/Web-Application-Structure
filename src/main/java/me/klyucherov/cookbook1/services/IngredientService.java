package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;


import java.util.Map;
import java.util.Optional;



public interface IngredientService {



    Ingredient nawIngredient(Ingredient ingredient);

    Optional<Ingredient> getById(Long id);

    Ingredient update(Long id, Ingredient ingredient);

    Ingredient delete(Long id);
    Map<Long, Ingredient> getAllIngredient();

}
