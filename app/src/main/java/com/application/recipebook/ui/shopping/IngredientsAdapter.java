package com.application.recipebook.ui.shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.application.recipebook.Ingredient;
import com.application.recipebook.R;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {

    private List<Ingredient> ingredients;

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public CheckBox checkBox;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
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

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return ingredients.size();
    }

}
