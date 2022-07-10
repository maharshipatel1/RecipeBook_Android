package com.application.recipebook;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
        String url = (String) intent.getSerializableExtra("URL");

        // WebView in this Activity
        WebView web = (WebView) findViewById(R.id.web_view);
        web.getSettings().setJavaScriptEnabled(true);

        web.loadUrl(url);
    }
}