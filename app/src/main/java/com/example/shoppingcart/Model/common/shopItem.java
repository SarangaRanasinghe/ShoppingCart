package com.example.shoppingcart.Model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class shopItem {

    String Type;
    String Brand;
    String Color;
    int Size;

    public shopItem() {
    }

    public shopItem(String type, String brand, String color, int size) {
        Type = type;
        Brand = brand;
        Color = color;
        Size = size;
    }

    public shopItem(String category, String product, Integer valueOf, String selectedItem) {
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }
}
