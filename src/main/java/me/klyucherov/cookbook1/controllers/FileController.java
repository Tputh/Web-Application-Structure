package me.klyucherov.cookbook1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.klyucherov.cookbook1.services.IngredientService;
import me.klyucherov.cookbook1.services.RecipeService;
;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
@Tag(name = "API по работе с файлами", description = "загрузка/выгрузка файлов рецептов и ингредиентов")
public class FileController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    @GetMapping("/recipe/export")
    @Operation(
            summary = "Выгрузка файла рецептов"
    )
    public ResponseEntity<InputStreamResource> downloadRecipeFail() {
        try {
            File recipeFile = recipeService.readFile();
            InputStreamResource resource = new InputStreamResource(new FileInputStream(recipeFile));

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(recipeFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "вложение; имя файла=" + recipeFile.getName())
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/recipe/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файла рецептов"
    )
    public ResponseEntity<String> uploadRecipeFile(@RequestParam MultipartFile file) {
        try {
            recipeService.uploadFile(file);
            return ResponseEntity.ok("файл импортирован");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла");
        }
    }

    @PostMapping(value = "/ingredient/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файла ингредиентов"
    )
    public ResponseEntity<String> uploadIngredientFile(@RequestParam MultipartFile file) {
        try {
            ingredientService.uploadFile(file);
            return ResponseEntity.ok("файл импортирован");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла");
        }
    }

}
