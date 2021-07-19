package com.application.recipebook.ui.recipes;

import java.io.Serializable;

public class Recipe implements Serializable {

    private String name;
    private String recipe;
    private String ingredients;

    private Recipe(){
        ingredients = "";
        name = "";
        recipe = "";
    }

    public Recipe(String name, String recipe, String ingredients){
        this.ingredients = ingredients;
        this.name = name;
        this.recipe = recipe;
    }

    public String getIngredients(){
        return ingredients;
    }

    public String getName(){
        return name;
    }

    public String getRecipe(){
        return recipe;
    }

    public void setIngredients(String ingredients){
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}