package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.model.Recipe;

public interface ValidationService {
     boolean validate(Ingredient ingredient);
     boolean validate(Recipe recipe);
}
