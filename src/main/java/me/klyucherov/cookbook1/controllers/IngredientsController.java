package me.klyucherov.cookbook1.controllers;
import me.klyucherov.cookbook1.model.Ingredients;
import me.klyucherov.cookbook1.services.IngredientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("ingredients")
public class IngredientsController {
    private final IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
        ingredientsService.createIngredients(new Ingredients("Яйца", 3, "шт"));
    }

    @PostMapping
    public ResponseEntity<Ingredients> createIngredients(@RequestBody Ingredients ingredients) {
        Ingredients createIngredients = ingredientsService.createIngredients(ingredients);
        return ResponseEntity.ok(createIngredients);
    }

    @GetMapping("{ingredientsId}")
    public ResponseEntity getIngredients(@PathVariable Long ingredientsId) {
        Ingredients ingredients = ingredientsService.getIngredientsById(ingredientsId);
        if(ingredients == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredients);
    }

    @PutMapping("{ingredientsId}")
    public ResponseEntity updateIngredients(@RequestBody Ingredients ingredients, @PathVariable Long ingredientsId) {
        Ingredients updateIngredients = ingredientsService.updateIngredients(ingredientsId, ingredients);
        return ResponseEntity.ok(updateIngredients);
    }
}
