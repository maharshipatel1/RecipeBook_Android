package com.application.recipebook.ui.recipes;

import java.io.Serializable;

public class Recipe implements Serializable {

    private String name;
    private String publisher;
    private String url;
    private int id;

    private Recipe(){
        name = "";
        publisher = "";
        url = "";
        id = 0;
    }

    public Recipe(String name, String publisher, String url, int id){
        this.name = name;
        this.publisher = publisher;
        this.url = url;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getUrl(){
        return url;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(int id){
        this.id = id;
    }
}