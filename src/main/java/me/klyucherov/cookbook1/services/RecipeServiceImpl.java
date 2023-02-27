package me.klyucherov.cookbook1.services;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import me.klyucherov.cookbook1.model.Recipe;
import me.klyucherov.cookbook1.model.exception.ValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{
    private static long generationId = 1;
    private Map<Long, Recipe> recipeMap = new HashMap<>();
    private final ValidationService validationService;
    private final FileService fileService;
    @Value("${path.to.recipes.file}")
    private String recipesFilePath;

    @Value("${name.for.recipes.files}")
    private String recipesFileName;
    private Path recipesPath;



    @Override
    public Recipe newRecipe(Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        recipeMap.put(generationId++, recipe);
        fileService.saveMapToFile(recipeMap, recipesPath);

        return recipe;
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return Optional.ofNullable(recipeMap.get(id));
    }

    @Override
    public Recipe update(Long id, Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        recipeMap.replace(id, recipe);
        fileService.saveMapToFile(recipeMap, recipesPath);

        return recipe;
    }

    @Override
    public Recipe delete(Long id) {
        Recipe recipe = recipeMap.remove(id);
        fileService.saveMapToFile(recipeMap, recipesPath);
        return recipe;
    }

    @Override
    public Map<Long, Recipe> getAllRecipe() {
        return recipeMap;
    }

    @Override
    public File readFile() {
        return recipesPath.toFile();
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        fileService.uploadFile(file, recipesPath);
        recipeMap = fileService.readMapFromFile(recipesPath, new TypeReference<Map<Long, Recipe>>() {});
    }

    @PostConstruct
    private void init() {
        recipesPath = Path.of(recipesFilePath, recipesFileName);
        recipeMap = fileService.readMapFromFile(recipesPath, new TypeReference<Map<Long, Recipe>>() {});
    }
}
