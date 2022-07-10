package com.application.recipebook;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A recipe activity class for displaying the activity
 */
public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        // An intent object to initialize a new activity
        Intent intent = this.getIntent();
        String url = (String) intent.getSerializableExtra("URL");

        // WebView to display the recipe
        WebView web = (WebView) findViewById(R.id.web_view);
        web.getSettings().setJavaScriptEnabled(true);

        web.loadUrl(url);
    }
}