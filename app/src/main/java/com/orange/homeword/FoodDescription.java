package com.orange.homeword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_description);

        Intent intent = getIntent();

        Recipes recipes = intent.getParcelableExtra("RECIPES");

        TextView title = findViewById(R.id.fdtxt_title);
        TextView desc = findViewById(R.id.fdtxt_descr);
        ImageView srccompat = findViewById(R.id.imageView_pic);
        TextView txt_ingredient = findViewById(R.id.fdtxt_ingredient);
        TextView txt_prepa = findViewById(R.id.fdtxt_prepa);

        Log.d("ST:", recipes.toString());



        title.setText(recipes.getName());
        desc.setText(recipes.getDescription());

        if(recipes.getSrccompat()!=0){
            srccompat.setImageResource(recipes.getSrccompat());
        }

        txt_ingredient.setText(recipes.getIngredient());
        txt_prepa.setText(recipes.getPreparation());
        desc.setGravity(Gravity.FILL_HORIZONTAL);
    }
}