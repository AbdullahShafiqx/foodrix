package com.example.foodrix.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrix.R;
import com.example.foodrix.Domain.Foods;
import com.example.foodrix.CartManager;
import com.example.foodrix.cart_item_model_class;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class BestFoodAdaptor extends RecyclerView.Adapter<BestFoodAdaptor.ViewHolder> {

    private final Context context;
    private List<Foods> bestFoods;

    // Constructor
    public BestFoodAdaptor(Context context, ArrayList<Foods> bestFoods) {
        this.context = context;
        this.bestFoods = bestFoods;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the current food item
        Foods food = bestFoods.get(position);

        // Bind the data to the views
        holder.product_img.setImageResource(food.product_img);
//        holder.product_img.setImageResource(context.getResources().getIdentifier(food.getImagePath(), "drawable", context.getPackageName()));
        holder.title.setText(food.title);
        holder.rating.setText(String.valueOf(food.rating));
        holder.time.setText(food.time + " min");
        
        holder.addButton.setOnClickListener(v -> {
            cart_item_model_class cartItem = new cart_item_model_class(
                    food.product_img,
                    food.title,
                    food.price, // Assuming price is correct, if not, adjust
                    1.50, // fee
                    1 // quantity
            );
            CartManager.getInstance().addToCart(cartItem);
            Toast.makeText(context, food.title + " added to cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {

        return bestFoods != null ? bestFoods.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        ImageView product_img;
        TextView title;
        TextView rating;
        TextView time;
        TextView addButton;

        // ViewHolder constructor
        public ViewHolder(View itemView1) {
            super(itemView1);
            product_img = itemView1.findViewById(R.id.productImage);
            title = itemView1.findViewById(R.id.titleTxt);
            rating = itemView1.findViewById(R.id.ratingTxt);
            time = itemView1.findViewById(R.id.timeTxt);
            addButton = itemView1.findViewById(R.id.addButton);
        }
    }

    // Method to update the data (could be used later if needed)
    public void updateData(List<Foods> newFoods) {
        this.bestFoods = newFoods;
        notifyDataSetChanged();
    }
}
