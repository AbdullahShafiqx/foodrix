package com.example.foodrix.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrix.Category_Deals_Activity;
import com.example.foodrix.Domain.Category;
import com.example.foodrix.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    private final Context context;
    private final List<Category> catItems;

    // Constructor
    public CategoryAdaptor(Context context, ArrayList<Category> items) {
        this.context = context;
        this.catItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the current category item
        Category category = catItems.get(position);

        // Set image and background dynamically
        holder.pic.setImageResource(category.imagePath);
        holder.pic.setBackgroundResource(category.backgroundPath);
        holder.titleTxt.setText(category.name);

        // Set OnClickListener dynamically
        holder.itemView.setOnClickListener(v -> {
            // Navigate to DealsActivity with the category name
            Intent intent = new Intent(context, Category_Deals_Activity.class); // Replace with DealsActivity if generic
            intent.putExtra("categoryName", category.name); // Pass category name dynamically
            context.startActivity(intent);
        });
    }

    /*@Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the current category item
        Category category = catItems.get(position);

        // Set image and background dynamically
        holder.pic.setImageResource(category.imagePath);
        holder.pic.setBackgroundResource(category.backgroundPath);
        holder.titleTxt.setText(String.valueOf(category.name));


          // Set OnClickListener for each category
        holder.itemView.setOnClickListener(v -> {
            if (category.name.equals("Burger")) {
                // Navigate to Burger_Activity
                Intent intent = new Intent(context, Burger_Activity.class);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(v -> {
            if (category.name.equals("Pizza")) {
                // Navigate to Burger_Activity
                Intent intent = new Intent(context, Burger_Activity.class);
                context.startActivity(intent);
            }
            });

            holder.itemView.setOnClickListener(v -> {
                if (category.name.equals("HotDog")) {
                    // Navigate to Burger_Activity
                    Intent intent = new Intent(context, Burger_Activity.class);
                    context.startActivity(intent);
                }
        });

    }*/

    @Override
    public int getItemCount() {
        return catItems != null ? catItems.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTxt;
        ImageView pic;

        // ViewHolder constructor
        public ViewHolder(View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.catNameTxt);
            pic = itemView.findViewById(R.id.imgCat);
        }
    }
}
