package com.example.foodrix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    public interface OnCartChangeListener {
        void onCartChanged();
    }

    private final List<cart_item_model_class> cartItems;
    private final OnCartChangeListener listener;

    public CartAdapter(List<cart_item_model_class> cartItems, OnCartChangeListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
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
        holder.totalEachItemTextView.setText(String.format("$%.2f", item.getPrice() * item.getQuantity()));
        holder.feeEachItemTextView.setText(String.format("Fee: $%.2f", item.getFee() * item.getQuantity()));
        holder.numberItemTextView.setText(String.valueOf(item.getQuantity()));
        holder.imageView.setImageResource(item.getImageRes());

        holder.plusCartButton.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            notifyItemChanged(position);
            if (listener != null) {
                listener.onCartChanged();
            }
        });

        holder.minusCartButton.setOnClickListener(v -> {
            int currentQty = item.getQuantity();
            if (currentQty > 1) {
                item.setQuantity(currentQty - 1);
                notifyItemChanged(position);
            } else {
                cartItems.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cartItems.size());
            }
            if (listener != null) {
                listener.onCartChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, totalEachItemTextView, feeEachItemTextView, numberItemTextView;
        TextView plusCartButton, minusCartButton;
        ImageView imageView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            totalEachItemTextView = itemView.findViewById(R.id.totalEachItemTextView);
            feeEachItemTextView = itemView.findViewById(R.id.feeEachItemTextView);
            numberItemTextView = itemView.findViewById(R.id.numberItemTextView);
            plusCartButton = itemView.findViewById(R.id.plusCartButton);
            minusCartButton = itemView.findViewById(R.id.minusCartButton);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
