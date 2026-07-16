package com.example.foodrix.Domain;
public class Category {
    public int imagePath;
    public int backgroundPath;
    public String name;

    public Category(int imagePath, int backgroundPath, String name) {
        this.imagePath = imagePath;
        this.backgroundPath = backgroundPath;
        this.name = name;
    }
}

//
//public class Category {
//    private int id;
//    private String imagePath;
//    private String name;
//
//    // Default constructor
//    public Category() {}
//
//    // Getter for id
//    public int getId() {
//        return id;
//    }
//
//    // Setter for id
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    // Getter for imagePath
//    public String getImagePath() {
//        return imagePath;
//    }
//
//    // Setter for imagePath
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }
//
//    // Getter for name
//    public String getName() {
//        return name;
//    }
//
//    // Setter for name
//    public void setName(String name) {
//        this.name = name;
//    }
//}
