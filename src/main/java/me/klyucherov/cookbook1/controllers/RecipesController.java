package me.klyucherov.cookbook1.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.klyucherov.cookbook1.model.Recipe;
import me.klyucherov.cookbook1.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
@Tag(name = "API по работе с рецептами")
public class RecipesController {
    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @Operation(
            summary = "Сохранение рецепта"
    )
   @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
      return ResponseEntity.ok(recipeService.newRecipe(recipe));
    }
    @Operation(
            summary = "Получение рецепта по id"
    )
    @GetMapping("/{id}")
    private ResponseEntity<Recipe> getById(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.getById(id));
    }
    @Operation(
            summary = "Обновление рецепта"
    )
    @PutMapping("/{id}")
    private ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.update(id, recipe));
    }
    @Operation(
            summary = "Удаление пецепта"
    )
    @DeleteMapping("/{id}")
    private ResponseEntity<Recipe> deleteRecipe(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.delete(id));
    }
    @Operation(
            summary = "Получение всех рецептов"
    )
    @GetMapping
    private ResponseEntity<Map<Long, Recipe>> getAll() {
        return ResponseEntity.ok(recipeService.getAllRecipe());
    }


}
