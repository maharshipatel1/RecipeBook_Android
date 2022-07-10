package com.application.recipebook;

/**
 * The Ingredient class to represent an ingredient object
 */
public class Ingredient {
    private String name;
    private boolean value;

    public Ingredient(){
        super();
    }

    public Ingredient(String name, boolean value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public boolean getValue(){
        return value;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setValue(boolean value){
        this.value = value;
    }


}
