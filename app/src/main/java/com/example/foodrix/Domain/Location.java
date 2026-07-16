package com.example.foodrix.Domain;

public class Location {
    private int Id;
    private String Loc;

    // Default constructor
    public Location() {}
@Override
public String toString(){
        return Loc;
}
    // Getter for Id
    public int getId() {
        return Id;
    }

    // Setter for Id
    public void setId(int id) {
        Id = id;
    }

    // Getter for Loc
    public String getLoc() {
        return Loc;
    }

    // Setter for Loc
    public void setLoc(String loc) {
        Loc = loc;
    }
}
