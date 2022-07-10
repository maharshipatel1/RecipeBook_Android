package com.application.recipebook.ui.recipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.application.recipebook.R;
import com.application.recipebook.RecipeActivity;
import com.bumptech.glide.RequestManager;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

/**
 * The recipes adapter class to implement the UI of each recipe element
 */
public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private List<Recipe> recipes;
    private RequestManager glide;
    private Context context;

    // This method initializes the members of the recipe element
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public ImageView image;

        public ViewHolder(View itemView) {

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.recipe_name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public RecipesAdapter(){
        super();
    }

    public RecipesAdapter(List<Recipe> recipes, RequestManager glide, Context context){
        this.recipes = recipes;
        this.glide = glide;
        this.context = context;
    }


    // This method is used to inflate the UI element
    @Override
    public RecipesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_recipe, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // This method initializes the connection to the databases
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int pos = holder.getAdapterPosition();

        // Get the recipe object
        Recipe recipe = recipes.get(pos);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(recipe.getName());

        // Reference to an image file in Cloud Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images/" + recipe.getId()+ ".jpeg");

        // ImageView in your Activity
        ImageView imageView = holder.image;

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        glide.load(storageReference).into(imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecipeActivity.class);
                intent.putExtra("URL", recipe.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
