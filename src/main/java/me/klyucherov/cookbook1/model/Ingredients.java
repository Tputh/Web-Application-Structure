package me.klyucherov.cookbook1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.klyucherov.cookbook1.model.exception.IncorrectArgumentException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients{
    private  String nameIngredient;
    private  int numberOfIngredients;
    private  String unitOfMeasurement;
    public void setNameIngredient(String nameIngredient) throws IncorrectArgumentException {
        if (nameIngredient != null && !nameIngredient.isEmpty() && !nameIngredient.isBlank()){
            this.nameIngredient = nameIngredient;
        }else {
            throw new IncorrectArgumentException("Внесите название ингредиента");
        }
    }
    public void setNumberOfIngredients(int numberOfIngredients) throws IncorrectArgumentException{
        if (numberOfIngredients != 0){
            this.numberOfIngredients = numberOfIngredients;
        }else {
            throw new IncorrectArgumentException("Внесите колиство ингредиентов");
        }
    }
    public void setUnitOfMeasurement(String unitOfMeasurement) throws IncorrectArgumentException {
        if (unitOfMeasurement != null && !unitOfMeasurement.isEmpty() && !unitOfMeasurement.isBlank()){
            this.unitOfMeasurement = unitOfMeasurement;
        }else {
            throw new IncorrectArgumentException("Внесите еденицу измерения");
        }
    }
}
