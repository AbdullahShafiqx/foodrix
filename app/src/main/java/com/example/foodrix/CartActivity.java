package com.example.foodrix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private static final int LOCATION_REQUEST_CODE = 1001;

    private TextView map;
    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private List<cart_item_model_class> cartItems = new ArrayList<>();

    private TextView subtotalValue, deliveryValue, taxValue, totalValue;
    private ImageView backBtn;
    private View placeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize display views
        subtotalValue = findViewById(R.id.subtotalValue);
        deliveryValue = findViewById(R.id.deliveryValue);
        taxValue = findViewById(R.id.taxValue);
        totalValue = findViewById(R.id.totalValue);
        backBtn = findViewById(R.id.cartBackButton);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        // Back button click helper
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> finish());
        }

        // Initialize RecyclerView
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get items from CartManager
        cartItems = CartManager.getInstance().getCartItems();

        // Set adapter with a callback to recalculate whenever quantities change
        cartAdapter = new CartAdapter(cartItems, new CartAdapter.OnCartChangeListener() {
            @Override
            public void onCartChanged() {
                recalculateCart();
            }
        });
        cartRecyclerView.setAdapter(cartAdapter);

        // Initial Calculation
        recalculateCart();

        map = findViewById(R.id.mapcall);
        // OnClickListener for the map button to pick location
        map.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, MapActivity.class);
            startActivityForResult(intent, LOCATION_REQUEST_CODE);
        });

        // Order placement logic
        if (placeOrderButton != null) {
            placeOrderButton.setOnClickListener(v -> {
                if (cartItems.isEmpty()) {
                    Toast.makeText(CartActivity.this, "Your cart is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CartActivity.this, "Order placed successfully! Thank you for ordering from Foodrix.", Toast.LENGTH_LONG).show();
                    cartItems.clear();
                    cartAdapter.notifyDataSetChanged();
                    recalculateCart();
                }
            });
        }
    }

    private void recalculateCart() {
        double subtotal = 0.0;
        double delivery = 0.0;

        for (cart_item_model_class item : cartItems) {
            subtotal += item.getPrice() * item.getQuantity();
            delivery += item.getFee() * item.getQuantity();
        }

        double tax = subtotal * 0.1; // 10% tax
        double total = subtotal + delivery + tax;

        subtotalValue.setText(String.format("$%.2f", subtotal));
        deliveryValue.setText(String.format("$%.2f", delivery));
        taxValue.setText(String.format("$%.2f", tax));
        totalValue.setText(String.format("$%.2f", total));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOCATION_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String selectedLocation = data.getStringExtra("selected_location");
            if (selectedLocation != null && map != null) {
                map.setText("Location Added ✓");
                Toast.makeText(this, "Pinned Location: " + selectedLocation, Toast.LENGTH_LONG).show();
            }
        }
    }
}
