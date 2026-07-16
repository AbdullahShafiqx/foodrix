package com.example.foodrix.Domain;

public class Price {
    private int Id;
    private String Value;

    // Default constructor
    public Price() {}
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
    public String getValue() {
        return Value;
    }

    // Setter for Loc
    public void setValue(String value) {
        Value = value;
    }
}
