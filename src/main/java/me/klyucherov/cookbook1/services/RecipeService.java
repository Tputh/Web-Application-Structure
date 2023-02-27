package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.model.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    File readFile();
    void uploadFile(MultipartFile file) throws IOException;
}










