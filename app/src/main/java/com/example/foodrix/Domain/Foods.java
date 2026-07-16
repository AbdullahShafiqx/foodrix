package com.example.foodrix.Domain;


public class Foods {
    public int product_img;
    public String title;
    public double rating ;
    public int time;

    public int price;    // Price of the burger

    public Foods(int product_img ,String title, double rating , int time,int price){

        this. product_img= product_img;
        this.title = title;
        this.rating= rating;
        this.time=time;
        this.price = price;
    }


}


//public class FoodsFromFirebase {
//    private String ImagePath; // Assuming you want to use the image path
//    private String Description;
//    private double Star;
//    private String Title;
//
//    // Constructor
//    public Foods(String description, String imagePath, double star, String title) {
//        this.Description = description;
//        this.ImagePath = imagePath;
//        this.Star = star;
//        this.Title = title;
//    }
//
//    // Getter for Description
//    public String getDescription() {
//        return Description;
//    }
//
//    // Setter for Description
//    public void setDescription(String description) {
//        Description = description;
//    }
//
//    // Getter for ImagePath (assuming it's a String that holds the image path)
//    public String getImagePath() {
//        return ImagePath;
//    }
//
//    // Setter for ImagePath
//    public void setImagePath(String imagePath) {
//        ImagePath = imagePath;
//    }
//
//    // Getter for Star rating
//    public double getStar() {
//        return Star;
//    }
//
//    // Setter for Star
//    public void setStar(double star) {
//        Star = star;
//    }
//
//    // Getter for Title
//    public String getTitle() {
//        return Title;
//    }
//
//    // Setter for Title
//    public void setTitle(String title) {
//        Title = title;
//    }
//
//
//}
