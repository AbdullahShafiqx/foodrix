package com.example.foodrix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<cart_item_model_class> cartItems;

    public CartAdapter(List<cart_item_model_class> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        cart_item_model_class item = cartItems.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.totalEachItemTextView.setText(String.format("$%.2f", item.getPrice()));
        holder.feeEachItemTextView.setText(String.format("Fee: $%.2f", item.getFee()));
        holder.numberItemTextView.setText(String.valueOf(item.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, totalEachItemTextView, feeEachItemTextView, numberItemTextView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            totalEachItemTextView = itemView.findViewById(R.id.totalEachItemTextView);
            feeEachItemTextView = itemView.findViewById(R.id.feeEachItemTextView);
            numberItemTextView = itemView.findViewById(R.id.numberItemTextView);
        }
    }
}
