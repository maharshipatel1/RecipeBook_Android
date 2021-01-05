package com.application.recipebook.ui.shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.recipebook.Ingredient;
import com.application.recipebook.R;
import com.application.recipebook.ui.inventory.IngredientsAdapter;

import java.util.ArrayList;
import java.util.List;

public class shoppingFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private List<Ingredient> ingredients;
    private RecyclerView rvIngredients;
    //private AdView mAdView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inventory, container, false);
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

        rvIngredients = (RecyclerView) view.findViewById(R.id.rvIngredients);
        ingredients = new ArrayList<Ingredient>();
        setIngredients(ingredients);

        IngredientsAdapter adapter = new IngredientsAdapter(ingredients);
        rvIngredients.setAdapter(adapter);
        rvIngredients.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void setIngredients(List<Ingredient> ingredientsList){
        ingredientsList.add(0, new Ingredient("Tomatoes", true));
        ingredientsList.add(1,new Ingredient("Onions", false));
        ingredientsList.add(2,new Ingredient("Peppers", false));
        ingredientsList.add(3,new Ingredient("Jalapenos", false));
        ingredientsList.add(4,new Ingredient("Potatoes", false));
        ingredientsList.add(5,new Ingredient("Garlic", false));
        ingredientsList.add(6,new Ingredient("Ginger", false));
        ingredientsList.add(7,new Ingredient("Panner", false));
        ingredientsList.add(8,new Ingredient("Tortillas", false));
        ingredientsList.add(9,new Ingredient("Beans", false));
        ingredientsList.add(10,new Ingredient("Mexican Cheese", false));
        ingredientsList.add(11,new Ingredient("Mozzrella Cheese", false));
        ingredientsList.add(12,new Ingredient("Bread", false));
        ingredientsList.add(13,new Ingredient("Pasta", false));
        ingredientsList.add(14,new Ingredient("Pasta Sauce", false));
        ingredientsList.add(15,new Ingredient("Garlic Bread", false));
        ingredientsList.add(16,new Ingredient("Rice", false));
        ingredientsList.add(17,new Ingredient("Cooked Rice", false));
        ingredientsList.add(18,new Ingredient("Channa", false));
        ingredientsList.add(19,new Ingredient("Toor Dal", false));
        ingredientsList.add(20,new Ingredient("Spices", false));
        ingredientsList.add(21,new Ingredient("Moong Dal", false));
        ingredientsList.add(22,new Ingredient("Cooking Oil", false));
        ingredientsList.add(23,new Ingredient("Butter", false));
        ingredientsList.add(24,new Ingredient("Coriander", false));
    }
}
