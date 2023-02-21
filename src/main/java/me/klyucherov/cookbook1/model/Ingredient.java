package me.klyucherov.cookbook1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private  String nameIngredient;
    private  int count;
    private  String measureUnit;
}
