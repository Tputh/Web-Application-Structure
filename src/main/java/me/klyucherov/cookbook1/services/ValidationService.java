package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.model.Recipe;

public interface ValidationService {
    public boolean validate(Ingredient ingredient);
    public boolean validate(Recipe recipe);
}
