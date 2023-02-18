package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.model.Recipe;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getNameIngredient() != null
                && ingredient.getCount() != 0
                && ingredient.getMeasureUnit() != null;
    }

    @Override
    public boolean validate(Recipe recipe) {
        return recipe != null
                && recipe.getNameRecipe() != null
                && recipe.getCookingTime() != 0
                && recipe.getSteps() != null
                && recipe.getIngredientsList().isEmpty()
                && recipe.getSteps().isEmpty();
    }
}
