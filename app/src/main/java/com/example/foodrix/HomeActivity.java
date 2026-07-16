package com.example.foodrix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrix.Adapter.BestFoodAdaptor;
import com.example.foodrix.Adapter.CategoryAdaptor;
import com.example.foodrix.Domain.Category;
import com.example.foodrix.Domain.Foods;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<Foods> bestFoods = new ArrayList<>();
    private ImageView logout;
    private ImageView cart;
    private Button chatbtn;
    private BestFoodAdaptor bestFoodAdaptor;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // RecyclerView for Best Foods
        RecyclerView recyclerView = findViewById(R.id.bestFoodView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Add food items to the list with diversified properties
        bestFoods.add(new Foods(R.drawable.classicbeefburger, "Classic Beef Burger", 4.5, 30, 12, "New York"));
        bestFoods.add(new Foods(R.drawable.bbqranchdelight, "BBQ Ranch Delight", 4.8, 25, 15, "Los Angeles"));
        bestFoods.add(new Foods(R.drawable.garlicparmesanchicken, "Garlic Chicken", 4.6, 20, 12, "London"));
        bestFoods.add(new Foods(R.drawable.hawaiianparadise, "Hawaiian Paradise", 4.7, 40, 35, "Tokyo"));
        bestFoods.add(new Foods(R.drawable.koreancfriedchicks, "Korean BBQ Short Ribs", 4.9, 50, 55, "New York"));
        bestFoods.add(new Foods(R.drawable.mediterraneanjoy, "Mediterranean Joy", 4.4, 35, 18, "Los Angeles"));
        bestFoods.add(new Foods(R.drawable.originalcripsychicks, "Original Crispy Chicken", 4.3, 15, 8, "London"));
        bestFoods.add(new Foods(R.drawable.honeymustardglazedtenders, "Teriyaki Glazed", 4.6, 20, 12, "Tokyo"));

        // Set BestFoodAdaptor for bestFoods RecyclerView
        bestFoodAdaptor = new BestFoodAdaptor(this, new ArrayList<>(bestFoods));
        recyclerView.setAdapter(bestFoodAdaptor);

        // Spinners logic
        Spinner locationSpinner = findViewById(R.id.locationSpinner);
        Spinner timeSpinner = findViewById(R.id.timeSpinner);
        Spinner priceSpinner = findViewById(R.id.priceSpinner);

        String[] locations = {"New York", "Los Angeles", "London", "Tokyo"};
        String[] times = {"15 mins", "30 mins", "45 mins", "1 hour"};
        String[] prices = {"$5 - $10", "$10 - $20", "$20 - $50", "$50+"};

        ArrayAdapter<String> locAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locAdapter);

        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, times);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

        ArrayAdapter<String> priceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, prices);
        priceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priceSpinner.setAdapter(priceAdapter);

        // Set spinner item selected listeners to filter best foods dynamically
        AdapterView.OnItemSelectedListener filterChangeListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filterFoods(
                        locationSpinner.getSelectedItem().toString(),
                        timeSpinner.getSelectedItem().toString(),
                        priceSpinner.getSelectedItem().toString()
                );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No action
            }
        };

        locationSpinner.setOnItemSelectedListener(filterChangeListener);
        timeSpinner.setOnItemSelectedListener(filterChangeListener);
        priceSpinner.setOnItemSelectedListener(filterChangeListener);

        // RecyclerView for Category items
        RecyclerView recyclerView2 = findViewById(R.id.categoryView);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Category> catItems = new ArrayList<>();
        catItems.add(new Category(R.drawable.btn_1, R.drawable.cat_0_background, "Pizza"));
        catItems.add(new Category(R.drawable.btn_2, R.drawable.cat_1_background, "Burger"));
        catItems.add(new Category(R.drawable.btn_3, R.drawable.cat_2_background, "Broast"));
        catItems.add(new Category(R.drawable.btn_4, R.drawable.cat_3_background, "Sushi"));
        catItems.add(new Category(R.drawable.btn_5, R.drawable.cat_4_background, "Meat"));
        catItems.add(new Category(R.drawable.btn_6, R.drawable.cat_5_background, "HotDog"));
        catItems.add(new Category(R.drawable.btn_7, R.drawable.cat_6_background, "Drinks"));

        // Set CategoryAdaptor for category RecyclerView
        CategoryAdaptor categoryAdaptor = new CategoryAdaptor(this, catItems);
        recyclerView2.setAdapter(categoryAdaptor);

        logout = findViewById(R.id.logoutIcon);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        AutoCompleteTextView searchBox = findViewById(R.id.searchBox);
        String[] suggestions = {"Pizza", "Burger", "HotDog", "Sharwama", "Beverage", "Sandwich", "Jucies"};

        ArrayAdapter<String> searchAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                suggestions
        );
        searchBox.setAdapter(searchAdapter);
        searchBox.setThreshold(1);

        searchBox.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSuggestion = searchAdapter.getItem(position);
            Toast.makeText(HomeActivity.this, "Selected: " + selectedSuggestion, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(HomeActivity.this, Category_Deals_Activity.class);
            intent.putExtra("categoryName", selectedSuggestion);
            startActivity(intent);
        });

        chatbtn = findViewById(R.id.chatid);
        chatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AIChat.class);
                startActivity(intent);
            }
        });

        cart = findViewById(R.id.cartIcon);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void filterFoods(String location, String timeStr, String priceStr) {
        ArrayList<Foods> filteredList = new ArrayList<>();

        // Parse timeStr (e.g. "30 mins", "1 hour")
        int timeLimit = 120;
        if (timeStr.contains("15")) {
            timeLimit = 15;
        } else if (timeStr.contains("30")) {
            timeLimit = 30;
        } else if (timeStr.contains("45")) {
            timeLimit = 45;
        } else if (timeStr.contains("1 hour")) {
            timeLimit = 60;
        }

        // Parse price range (e.g. "$10 - $20")
        int minPrice = 0;
        int maxPrice = Integer.MAX_VALUE;
        if (priceStr.equals("$5 - $10")) {
            minPrice = 5;
            maxPrice = 10;
        } else if (priceStr.equals("$10 - $20")) {
            minPrice = 10;
            maxPrice = 20;
        } else if (priceStr.equals("$20 - $50")) {
            minPrice = 20;
            maxPrice = 50;
        } else if (priceStr.equals("$50+")) {
            minPrice = 50;
            maxPrice = Integer.MAX_VALUE;
        }

        for (Foods food : bestFoods) {
            boolean matchesLoc = food.location.equalsIgnoreCase(location);
            boolean matchesTime = food.time <= timeLimit;
            boolean matchesPrice = food.price >= minPrice && food.price <= maxPrice;

            if (matchesLoc && matchesTime && matchesPrice) {
                filteredList.add(food);
            }
        }

        if (bestFoodAdaptor != null) {
            bestFoodAdaptor.updateData(filteredList);
        }
    }
}
