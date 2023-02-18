package me.klyucherov.cookbook1.controllers;
import me.klyucherov.cookbook1.model.Recipe;
import me.klyucherov.cookbook1.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PatchMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
      return ResponseEntity.ok(recipeService.newRecipe(recipe));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Recipe> getById(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.getById(id));
    }


}
