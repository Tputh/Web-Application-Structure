package me.klyucherov.cookbook1.model;


import java.util.List;
import java.util.Objects;


public class Recipe {

    private  String nameRecipe;
    private  int cookingTime;
    private List<Ingredient> ingredientsList;
    private List<String> steps;

    public Recipe(String nameRecipe, int cookingTime, List<Ingredient> ingredientsList, List<String> steps) {
        this.nameRecipe = nameRecipe;
        this.cookingTime = cookingTime;
        this.ingredientsList = ingredientsList;
        this.steps = steps;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }
    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<String> getSteps() {
        return steps;
    }
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }
    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public int getCookingTime() {
        return cookingTime;
    }
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return cookingTime == recipe.cookingTime && Objects.equals(nameRecipe, recipe.nameRecipe) && Objects.equals(ingredientsList, recipe.ingredientsList) && Objects.equals(steps, recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameRecipe, cookingTime, ingredientsList, steps);
    }

    @Override
    public String toString() {
        return nameRecipe + ": " + "Время приготовления - " + cookingTime + " мин: " +
                "Ингредиенты - " + ingredientsList + ": " + "Шаги приготовления: " + steps;
    }
}

