package me.klyucherov.cookbook1.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.klyucherov.cookbook1.model.Ingredient;
import me.klyucherov.cookbook1.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/ingredient")
@Tag(name = "API по работе с ингредиентами")
public class IngredientsController {
    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(
            summary = "Сохранение ингредиента"
    )
    @PostMapping
    public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.nawIngredient(ingredient));
    }
    @Operation(
            summary = "Получение ингредиента по id"
    )
    @GetMapping("/{id}")
    private ResponseEntity<Ingredient> getById(@PathVariable Long id) {
        return ResponseEntity.of(ingredientService.getById(id));
    }
    @Operation(
            summary = "Обновление ингредиента"
    )
    @PutMapping("/{id}")
    private ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.update(id, ingredient));
    }
    @Operation(
            summary = "Удаление ингредиента"
    )
    @DeleteMapping("/{id}")
    private ResponseEntity<Ingredient> deleteIngredient(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientService.delete(id));
    }
    @Operation(
            summary = "Получение всех ингредиентов"
    )
    @GetMapping
    private ResponseEntity<Map<Long, Ingredient>> getAll() {
        return ResponseEntity.ok(ingredientService.getAllIngredient());
    }
}
