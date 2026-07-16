package com.example.foodrix;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<cart_item_model_class> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public List<cart_item_model_class> getCartItems() {
        return cartItems;
    }

    public void addToCart(cart_item_model_class item) {
        boolean exists = false;
        for (cart_item_model_class cartItem : cartItems) {
            if (cartItem.getTitle().equals(item.getTitle())) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                exists = true;
                break;
            }
        }
        if (!exists) {
            cartItems.add(item);
        }
    }
}
