package me.klyucherov.cookbook1.controllers;
import me.klyucherov.cookbook1.model.Ingredients;
import me.klyucherov.cookbook1.model.Recipe;
import me.klyucherov.cookbook1.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(new Ingredients("Яйца", 3, "шт"));
        List<String> cooked = new ArrayList<>();
        cooked.add("шаг 1");

        recipeService.createRecipe(new Recipe(ingredients, cooked, " Яишница ", 10));
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return ResponseEntity.ok(createdRecipe);
    }

    @GetMapping("{recipeId}")
    public ResponseEntity getRecipe(@PathVariable Long recipeID) {
        Recipe recipe = recipeService.getRecipeById(recipeID);
        if(recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("{recipeId}")
    public ResponseEntity updateRecipe(@RequestBody Recipe recipe, @PathVariable Long recipeID) {
        Recipe updateRecipe = recipeService.updateRecipe(recipeID, recipe);
        return ResponseEntity.ok(updateRecipe);
    }

}
