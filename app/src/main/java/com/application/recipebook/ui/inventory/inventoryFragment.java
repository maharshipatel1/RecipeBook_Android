package com.application.recipebook.ui.inventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.recipebook.Ingredient;
import com.application.recipebook.MainActivity;
import com.application.recipebook.R;

import java.util.List;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

public class inventoryFragment extends Fragment implements AdapterView.OnItemSelectedListener {

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
        ingredients = MainActivity.getIngredientList().getIngredients();

        IngredientsAdapter adapter = new IngredientsAdapter(ingredients);
        rvIngredients.setAdapter(adapter);
        rvIngredients.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        boolean checked = ((CheckBox) view).isChecked();

        if(checked == true){
            ingredients.get(position).setValue(true);
        }
        else{
            ingredients.get(position).setValue(false);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


}

