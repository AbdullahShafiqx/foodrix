package com.example.foodrix;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrix.Adapter.Category_Deals_Adapter;
import com.example.foodrix.Domain.Foods;

import java.util.ArrayList;

public class Category_Deals_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.category_deals_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back Button Functionality
        findViewById(R.id.backbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the current activity
            }
        });

        RecyclerView burgerRecyclerView = findViewById(R.id.burgerRecyclerView);
        burgerRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

// Add spacing between items
        burgerRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.left = 8;
                outRect.right = 8;
                outRect.top = 8;
                outRect.bottom = 8;
            }
        });

        String categoryName = getIntent().getStringExtra("categoryName"); // Get category name
        ((TextView) findViewById(R.id.titleText)).setText(categoryName + "' Deals"); // Set title

// Dynamically load data based on category
        ArrayList<Foods> items = new ArrayList<>();
        if ("Burger".equals(categoryName)) {
            items.add(new Foods(R.drawable.spicyburger, "  Spicy Jalapeño", 4.6, 23, 10));
            items.add(new Foods(R.drawable.mushroomburger, " Mushrom Swiss", 4.6, 15, 20));
            items.add(new Foods(R.drawable.veggieextravaganza, " Veggie Extrav", 4.6, 40, 5));
            items.add(new Foods(R.drawable.baconandcheeseheaven, " Cheese Heaven", 4.6, 30, 5));
            items.add(new Foods(R.drawable.classicbeef, "Classic Beef", 4.6, 25, 15));
            items.add(new Foods(R.drawable.bbqranch, "BBQ Ranch ", 4.6, 32, 10));
            items.add(new Foods(R.drawable.chillicheese, " Chilli Cheese", 4.6, 23, 20));
            items.add(new Foods(R.drawable.hawaiianburger, " Hawaian Burger", 4.6, 23, 10));
        } else if ("Pizza".equals(categoryName)) {
            items.add(new Foods(R.drawable.meatfeastpizza, "Meat Feast", 4.8, 20, 10));
            items.add(new Foods(R.drawable.margherita, "Margherita", 4.9, 25, 15));
            items.add(new Foods(R.drawable.veggiesupreme, "Eggie Supreme", 4.9, 25, 5));
            items.add(new Foods(R.drawable.pepperonilovers, "Pepperoni", 4.9, 25, 20));
            items.add(new Foods(R.drawable.margherita, "Margherita", 4.9, 25, 5));
            items.add(new Foods(R.drawable.margheritaflatbread, "Flat Bread", 4.9, 25, 15));
            items.add(new Foods(R.drawable.hawaiianparadise, "Paradise", 4.9, 25, 15));
            items.add(new Foods(R.drawable.meatfeastpizza, "Rob Pizza", 4.9, 25, 15));
        }
        else if ("HotDog".equals(categoryName)) {
            items.add(new Foods(R.drawable.hawaiianbbqhotdog, "Onion Hot Dog", 4.8, 20, 10));
            items.add(new Foods(R.drawable.chicagostylehotdog, "Ciago Hot Dog", 4.9, 25, 15));
            items.add(new Foods(R.drawable.classicbeefhotdog, "Eggie Hot Dog", 4.9, 25, 5));
            items.add(new Foods(R.drawable.kimchhotdog, "Cusine Hot Dog", 4.9, 25, 10));
            items.add(new Foods(R.drawable.reubenstylehotdog, "Rita Hot Dog", 4.9, 25, 20));
            items.add(new Foods(R.drawable.chilicheesedog, "Flat Hot Dog", 4.9, 25, 25));
            items.add(new Foods(R.drawable.hawaiianbbqhotdog, "Roll Hot Dog", 4.9, 25, 10));
            items.add(new Foods(R.drawable.chicagostylehotdog, "Rob Hot Dog", 4.9, 25, 10));
        }

        Category_Deals_Adapter adapter = new Category_Deals_Adapter(this, items);
        burgerRecyclerView.setAdapter(adapter);

    }
}
/*
//Burger Deals to show
        ArrayList<Foods> burgers = new ArrayList<>();
        burgers.add(new Foods(R.drawable.veggieextravaganza, " Veggie Extrav", 4.6, 40,15));
        burgers.add(new Foods(R.drawable.baconandcheeseheaven, " Cheese Heaven", 4.6, 30,12));
        burgers.add(new Foods(R.drawable.spicyburger, "  Spicy Jalapeño", 4.6, 23,10));
        burgers.add(new Foods(R.drawable.mushroomburger, " Mushrom Swiss", 4.6, 15,20));
        burgers.add(new Foods(R.drawable.classicbeef, "Classic Beef", 4.6, 25,20));
        burgers.add(new Foods(R.drawable.bbqranch, "BBQ Ranch ", 4.6, 32,10));
        burgers.add(new Foods(R.drawable.chillicheese, " Chilli Cheese", 4.6, 23,10));
        burgers.add(new Foods(R.drawable.hawaiianburger, " Hawaian Burger", 4.6, 23,10));

        BurgerAdapter adapter = new BurgerAdapter(this, burgers);
        burgerRecyclerView.setAdapter(adapter);
    }*/



