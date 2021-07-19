package com.application.recipebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.application.recipebook.ui.recipes.Recipe;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = this.getIntent();
        Recipe recipe = (Recipe) intent.getSerializableExtra("RECIPE");

        // Reference to an image file in Cloud Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images/" + recipe.getName() + ".jpg");

        // ImageView in your Activity
        ImageView recipeImage = (ImageView) findViewById(R.id.recipeImage);

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        Glide.with(getBaseContext()).load(storageReference).into(recipeImage);

        TextView recipeName = (TextView)findViewById(R.id.recipeName);
        TextView recipeMethod = (TextView)findViewById(R.id.recipeMethod);
        TextView recipeIngredients = (TextView)findViewById(R.id.recipeIngredients);

        recipeName.setText(recipe.getName());
        recipeMethod.setText(recipe.getRecipe().replace("_n", "\n"));
        recipeIngredients.setText(recipe.getIngredients());
    }
}