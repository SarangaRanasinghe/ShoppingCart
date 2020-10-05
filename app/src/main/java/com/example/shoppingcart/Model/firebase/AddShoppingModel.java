package com.example.shoppingcart.Model.firebase;

import com.example.shoppingcart.Model.common.shopItem;

import java.util.Map;

public class AddShoppingModel {

    Map<String, shopItem> sales;
    String date;

    public AddShoppingModel() {
    }

    public AddShoppingModel(Map<String, shopItem> sales, String date) {
        this.sales = sales;
        this.date = date;
    }

    public Map<String, shopItem> getSales() {
        return sales;
    }

    public void setSales(Map<String, shopItem> sales) {
        this.sales = sales;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
