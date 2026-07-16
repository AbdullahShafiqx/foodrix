package com.example.foodrix.Domain;

public class Foods {
    public int product_img;
    public String title;
    public double rating;
    public int time;
    public int price;
    public String location;

    public Foods(int product_img, String title, double rating, int time, int price) {
        this.product_img = product_img;
        this.title = title;
        this.rating = rating;
        this.time = time;
        this.price = price;
        this.location = "New York"; // Default location
    }

    public Foods(int product_img, String title, double rating, int time, int price, String location) {
        this.product_img = product_img;
        this.title = title;
        this.rating = rating;
        this.time = time;
        this.price = price;
        this.location = location;
    }
}
