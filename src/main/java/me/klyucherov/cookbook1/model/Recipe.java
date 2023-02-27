package me.klyucherov.cookbook1.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Recipe {

    private  String nameRecipe;
    private  int cookingTime;
    private List<Ingredient> ingredientsList;
    private List<String> steps;

}

