package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.model.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class IngredientServiceImpl implements IngredientService{
    private static long generationId = 1;
    private final Map<Long, Ingredient> ingredientMap = new HashMap<>();
    private final ValidationService validationService;

    public IngredientServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Ingredient newRecipe(Ingredient ingredient){
        if (!validationService.validate(ingredient)) {
           throw new ValidationException(ingredient.toString());
        }
        return ingredientMap.put(generationId++, ingredient);
    }
    @Override
    public Optional<Ingredient> getById(Long id){
        return Optional.ofNullable(ingredientMap.get(id));
    }

    @Override
    public Ingredient update(Long id, Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredientMap.replace(id, ingredient);
    }

    @Override
    public Ingredient delete(Long id) {
        return ingredientMap.remove(id);
    }

    @Override
    public Map<Long, Ingredient> getAllIngredient() {
        return ingredientMap;
    }
}
