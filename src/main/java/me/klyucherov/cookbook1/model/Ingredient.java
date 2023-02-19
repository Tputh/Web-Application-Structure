package me.klyucherov.cookbook1.model;

import java.util.Objects;


public class Ingredient {
    private  String nameIngredient;
    private  int count;
    private  String measureUnit;

    public Ingredient(String nameIngredient, int count, String measureUnit) {
        this.nameIngredient = nameIngredient;
        this.count = count;
        this.measureUnit = measureUnit;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }
    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }
    public void setMeasureUnit(String unitOfMeasurement) {
        this.measureUnit = measureUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return count == that.count && Objects.equals(nameIngredient, that.nameIngredient) && Objects.equals(measureUnit, that.measureUnit);
    }

    @Override public int hashCode() {
        return Objects.hash(nameIngredient, count, measureUnit);
    }

    @Override
    public String toString() {
        return "Ингредиенты: " + nameIngredient + count + measureUnit;
    }
}
