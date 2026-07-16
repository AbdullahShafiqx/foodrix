package com.example.foodrix.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrix.Domain.Foods;
import com.example.foodrix.R;
import com.example.foodrix.CartManager;
import com.example.foodrix.cart_item_model_class;
import android.widget.Toast;

import java.util.List;

public class Category_Deals_Adapter extends RecyclerView.Adapter<Category_Deals_Adapter.BurgerViewHolder> {

    private final Context context;
    private final List<Foods> burgerList;

    // Constructor
    public Category_Deals_Adapter(Context context, List<Foods> burgerList) {
        this.context = context;
        this.burgerList = burgerList;
    }

    @NonNull
    @Override
    public BurgerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_burger_deals, parent, false);
        return new BurgerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BurgerViewHolder holder, int position) {
        // Get the current food item from the list
        Foods food = burgerList.get(position);

        // Bind the data to the views in the ViewHolder
        holder.productImage.setImageResource(food.product_img); // Set image from drawable resources
        holder.title.setText(food.title);                      // Set the title
        holder.rating.setText(String.valueOf(food.rating));    // Set the rating
        holder.time.setText(food.time + " min");
        holder.price.setText("$" + food.price);                // Set the price

        holder.addButton.setOnClickListener(v -> {
            cart_item_model_class cartItem = new cart_item_model_class(
                    food.product_img,
                    food.title,
                    food.price,
                    1.50, // default fee
                    1
            );
            CartManager.getInstance().addToCart(cartItem);
            Toast.makeText(context, food.title + " added to cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        // Return the size of the burger list
        return burgerList != null ? burgerList.size() : 0;
    }

    // ViewHolder class for holding item views
    public static class BurgerViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;   // Image of the burger
        TextView title;           // Title of the burger
        TextView rating;          // Rating of the burger
        TextView time;            // Preparation time
        TextView price;           // Price of the burger
        TextView addButton;       // Add to cart button

        // Constructor for the ViewHolder
        public BurgerViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the views from the layout
            productImage = itemView.findViewById(R.id.p_img);
            title = itemView.findViewById(R.id.tit_Txt);
            rating = itemView.findViewById(R.id.r_Txt);
            time = itemView.findViewById(R.id.t_Txt);
            price = itemView.findViewById(R.id.price); 
            addButton = itemView.findViewById(R.id.addButton);
        }
    }
}

