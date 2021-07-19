package com.application.recipebook.ui.recipes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.recipebook.MainActivity;
import com.application.recipebook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

public class recipesFragment extends Fragment {

    //private AdView mAdView;
    private RecyclerView rvRecipes;
    private List<Recipe> recipes = new ArrayList<Recipe>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recipes, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*mAdView = getView().findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        basicRead(getIngredients(), view);
    }

    public String getIngredients() {
        List<String> temp = new ArrayList<String>();
        String result = "";

        for (int i = 0; i < MainActivity.getIngredientList().getIngredients().size(); i++) {

            if (MainActivity.getIngredientList().getIngredients().get(i).getValue() == true) {
                temp.add(MainActivity.getIngredientList().getIngredients().get(i).getName());
            }

        }

        Collections.sort(temp);

        for (int i = 0; i < temp.size(); i++) {

            if (result.equals("")) {
                result = temp.get(i);
            } else {
                result = result + "," + temp.get(i);
            }
        }

        return result;
    }

    public void basicRead(String ingredientsAvailable, View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ingredientRef = database.getReference();

        System.out.println("Ingredients available: " + ingredientsAvailable);

        ingredientRef.child("Recipes").child(ingredientsAvailable).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {

                    for(DataSnapshot postSnapshot: task.getResult().getChildren()){
                        recipesFragment.this.recipes.add(postSnapshot.getValue(Recipe.class));
                    }

                    System.out.println(recipesFragment.this.recipes.size());

                    rvRecipes = (RecyclerView) view.findViewById(R.id.rvRecipes);

                    RecipesAdapter adapter = new RecipesAdapter(recipes, GlideApp.with(getContext()), getContext());
                    rvRecipes.setAdapter(adapter);
                    rvRecipes.setLayoutManager(new LinearLayoutManager(recipesFragment.this.getContext()));
                }
            }
        });

    }


}

