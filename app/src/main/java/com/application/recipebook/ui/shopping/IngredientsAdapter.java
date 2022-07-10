package com.application.recipebook.ui.shopping;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.application.recipebook.Ingredient;
import com.application.recipebook.MainActivity;
import com.application.recipebook.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * The adapter class to represent each ingredient in the shopping fragment
 */
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {

    private List<Ingredient> ingredients;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public CheckBox checkBox;

        public ViewHolder(View itemView) {

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.ingredient_name);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

    public IngredientsAdapter(){
        super();
    }

    public IngredientsAdapter(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    // This method inflates the item in the adapter
    @Override
    public IngredientsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_ingredient, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(IngredientsAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        String tempIngredient = ingredients.get(position).getName();

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(tempIngredient);
        CheckBox checkBox = holder.checkBox;
        if(ingredients.get(position).getValue() == true){
            checkBox.setChecked(true);
        }
        else{
            checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return MainActivity.getIngredientList().getIngredients().size();
    }

}
