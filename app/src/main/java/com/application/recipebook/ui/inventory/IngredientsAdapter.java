package com.application.recipebook.ui.inventory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.recipebook.Ingredient;
import com.application.recipebook.R;

import java.util.List;

/**
 * This adapter class maintains a UI object for each ingredient
 */
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {

    private List<Ingredient> ingredients;

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
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

    // This method inflates the view of the adapter item
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

        int pos = holder.getAdapterPosition();

        // Get the data model based on position
        String tempIngredient = ingredients.get(pos).getName();

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(tempIngredient);
        CheckBox checkBox = holder.checkBox;
        if(ingredients.get(pos).getValue() == true){
            checkBox.setChecked(true);
        }
        else{
            checkBox.setChecked(false);
        }

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ingredients.get(pos).setValue(true);
                }
                else {
                    ingredients.get(pos).setValue(false);
                }
            }

        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return ingredients.size();
    }

}
