package me.klyucherov.cookbook1.services;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.model.exception.ValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService{
    private static long generationId = 1;
    private Map<Long, Ingredient> ingredientMap = new HashMap<>();
    private final ValidationService validationService;
    private final FileService fileService;

    @Value("${path.to.ingredients.file}")
    private String ingredientsFilePath;

    @Value("${name.for.ingredients.files}")
    private String ingredientsFileName;
    private Path ingredientPath;


    @Override
    public Ingredient nawIngredient(Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        ingredientMap.put(generationId++, ingredient);
        fileService.saveMapToFile(ingredientMap, ingredientPath);

        return ingredient;
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
        ingredientMap.replace(id, ingredient);
        fileService.saveMapToFile(ingredientMap, ingredientPath);

        return ingredient;
    }

    @Override
    public Ingredient delete(Long id) {
        Ingredient ingredient = ingredientMap.remove(id);
        fileService.saveMapToFile(ingredientMap, ingredientPath);
        return ingredient;
    }

    @Override
    public Map<Long, Ingredient> getAllIngredient() {
        return ingredientMap;
    }

    @PostConstruct
    private void init() {
        ingredientPath = Path.of(ingredientsFilePath, ingredientsFileName);
        ingredientMap = fileService.readMapFromFile(ingredientPath, new TypeReference<HashMap<Long, Ingredient>>() {});
    }
}
