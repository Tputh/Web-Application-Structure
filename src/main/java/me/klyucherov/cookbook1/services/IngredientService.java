package me.klyucherov.cookbook1.services;

import me.klyucherov.cookbook1.model.Ingredient;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;



public interface IngredientService {



    Ingredient nawIngredient(Ingredient ingredient);

    Optional<Ingredient> getById(Long id);

    Ingredient update(Long id, Ingredient ingredient);

    Ingredient delete(Long id);
    Map<Long, Ingredient> getAllIngredient();
    File readFile();
    void uploadFile(MultipartFile file) throws IOException;

}
