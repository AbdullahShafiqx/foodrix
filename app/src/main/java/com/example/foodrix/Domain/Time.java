package com.example.foodrix.Domain;

public class Time {
    private int Id;
    private String Value;

    // Default constructor
    public Time() {}
    @Override
    public String toString(){
        return Value;
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
    public String getTimeValue() {
        return Value;
    }

    // Setter for Loc
    public void setTimeValue(String value) {
        Value= value;
    }
}
