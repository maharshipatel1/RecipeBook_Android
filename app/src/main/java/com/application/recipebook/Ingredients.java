package com.application.recipebook;

import java.util.ArrayList;
import java.util.List;

/**
 * The ingredients class for implementing each ingredient in the list
 */
public class Ingredients {

    private List<Ingredient> ingredients;

    public Ingredients(){
        ingredients = new ArrayList<Ingredient>();
        setIngredients();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    // The setter method for setting each element in the ingredients list
    public void setIngredients(){
        ingredients.add(0, new Ingredient("Tomatoes", false));
        ingredients.add(1,new Ingredient("Onions", false));
        ingredients.add(2,new Ingredient("Peppers", false));
        ingredients.add(3,new Ingredient("Jalapenos", false));
        ingredients.add(4,new Ingredient("Potatoes", false));
        ingredients.add(5,new Ingredient("Garlic", false));
        ingredients.add(6,new Ingredient("Ginger", false));
        ingredients.add(7,new Ingredient("Panner", false));
        ingredients.add(8,new Ingredient("Tortillas", false));
        ingredients.add(9,new Ingredient("Beans", false));
        ingredients.add(10,new Ingredient("Mexican Cheese", false));
        ingredients.add(11,new Ingredient("Mozzrella Cheese", false));
        ingredients.add(12,new Ingredient("Bread", false));
        ingredients.add(13,new Ingredient("Pasta", false));
        ingredients.add(14,new Ingredient("Pasta Sauce", false));
        ingredients.add(15,new Ingredient("Garlic Bread", false));
        ingredients.add(16,new Ingredient("Rice", false));
        ingredients.add(17,new Ingredient("Cooked Rice", false));
        ingredients.add(18,new Ingredient("Channa", false));
        ingredients.add(19,new Ingredient("Toor Dal", false));
        ingredients.add(20,new Ingredient("Spices", false));
        ingredients.add(21,new Ingredient("Moong Dal", false));
        ingredients.add(22,new Ingredient("Cooking Oil", false));
        ingredients.add(23,new Ingredient("Butter", false));
        ingredients.add(24,new Ingredient("Coriander", false));
    }
}
