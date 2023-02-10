package me.klyucherov.cookbook1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.klyucherov.cookbook1.model.exception.IncorrectArgumentException;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private List<Ingredients> ingredientsList = new ArrayList<>();
    private List<String> cookedList = new ArrayList<>();

    private  String title;
    private  int cookingTime;




    public void setTitle(String title) throws IncorrectArgumentException{
        if (title != null && title.isEmpty() && title.isBlank()){
            this.title =  title;
        }else {
            throw new IncorrectArgumentException("Внесите название рецепта");
        }
    }
}

