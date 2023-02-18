package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Recipe;
import me.klyucherov.cookbook1.model.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class RecipeServiceImpl implements RecipeService{
    private static long generationId = 1;
    private Map<Long, Recipe> recipeMap = new HashMap<>();
    private final ValidationService validationService;

    public RecipeServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Recipe newRecipe(Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        return recipeMap.put(generationId++, recipe);
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return Optional.ofNullable(recipeMap.get(id));
    }
}
