package com.orange.homeword;

import static androidx.core.content.res.ResourcesCompat.getDrawable;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesHolder> {

    private final LinkedList<Recipes> recipesList;
    private final LayoutInflater mInflater;
    private final CardView card;
    private final LinearLayout lnly;

    public RecipesAdapter(Context context, LinkedList<Recipes> recipesList, CardView card, LinearLayout lnly) {
        mInflater = LayoutInflater.from(context);
        this.recipesList = recipesList;
        this.card = card;
        this.lnly = lnly;
    }

    @NonNull
    @Override
    public RecipesAdapter.RecipesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipes_item, parent, false);
        return new RecipesAdapter.RecipesHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(@NonNull RecipesHolder holder, int position) {
        Recipes mCurrentRecipes = recipesList.get(position);
        CardView card = holder.card;
//        //draw
//        TextView ingre = holder.txt_ingredient;
//        ingre.setText(m);
//        imageview.setImageDrawable(getDrawable(mCurrentRecipes.getSrccompat()));
        card.cancelLongPress();
        Log.d("Current RECIPES !", mCurrentRecipes.toString());
        LinearLayout lnly = holder.lnly;
        // 1: Title
        TextView title = holder.txt_title;
        title.setText(mCurrentRecipes.getName());
        //2: Description
        TextView desc = holder.txt_description;
        desc.setText(mCurrentRecipes.getDescription().substring(0,50)+"...");
        //3: code
        ImageView imageview = holder.srccompat;
        imageview.setImageResource(mCurrentRecipes.getSrccompat());
        //4: Ingredient
        TextView ingre = holder.txt_ingredient;
        ingre.setText(mCurrentRecipes.getIngredient().substring(0,0));
        //5: Preparation
        TextView prepa = holder.txt_prepa;
        prepa.setText(mCurrentRecipes.getPreparation().substring(0,0));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return recipesList.size();
    }

    class RecipesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final CardView card;
        public final LinearLayout lnly;
        public final TextView txt_title;
        public final TextView txt_description;
        public final TextView codeimage;
        public final ImageView srccompat;
        public final TextView txt_ingredient;
        public final TextView txt_prepa;
        final RecipesAdapter mAdapter;

        public RecipesHolder(@NonNull View itemView, RecipesAdapter mAdapter) {
            super(itemView);
            this.card = itemView.findViewById(R.id.card);
            this.lnly = itemView.findViewById(R.id.linear_layout) ;
            this.txt_title = itemView.findViewById(R.id.txt_view_item_title);
            this.txt_description = itemView.findViewById(R.id.txt_view_item_description);
            this.srccompat = itemView.findViewById(R.id.imageitem);
            this.txt_ingredient = itemView.findViewById(R.id.txt_view_item_ingredient);
            this.txt_prepa = itemView.findViewById(R.id.txt_view_item_preparation);
            this.codeimage = itemView.findViewById(R.id.txt_view_item_code);
            this.mAdapter = mAdapter;
            this.card.setOnClickListener(this);
//            itemView.setOnClickListener(this);

        }

        @Override
//        public void onClick(View view) {
//            card.setOnClickListener(new View.OnClickListener() {
//                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    Recipes recipes = recipesList.get(position);
                    Intent intent = new Intent(view.getContext(), FoodDescription.class);
                    Log.d("RECIPES:",recipes.toString());
                    intent.putExtra("RECIPES",recipes);
                    //  Start new activity
                    ContextCompat.startActivity(view.getContext(),intent, null);
//                }
            }
//            )
        ;

//        }
    }
}
