package com.example.foodrix;



    public class cart_item_model_class {
        private int imageRes;
        private String title;
        private double price;
        private double fee;
        private int quantity;

        public cart_item_model_class(int imageRes, String title, double price, double fee, int quantity) {
            this.imageRes = imageRes;
            this.title = title;
            this.price = price;
            this.fee = fee;
            this.quantity = quantity;
        }

        // Getters

        public int getImageRes() { return imageRes; }
        public String getTitle() { return title; }
        public double getPrice() { return price; }
        public double getFee() { return fee; }
        public int getQuantity() { return quantity; }
        
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }

