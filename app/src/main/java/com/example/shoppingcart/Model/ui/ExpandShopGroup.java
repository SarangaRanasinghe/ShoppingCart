package com.example.shoppingcart.Model.ui;

import com.example.shoppingcart.Model.common.shopItem;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExpandShopGroup implements Comparable<ExpandShopGroup>, Serializable {

    private String shoppingID;
    private String date;
    private String name;
    private ArrayList<shopItem> Items;

    @Override
    public int compareTo(ExpandShopGroup expandShopGroup) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ssZ");

        try
        {
            return sdf.parse(getDate()).compareTo(sdf.parse(expandShopGroup.getDate()));
        }

        catch (ParseException e)
        {
            return 1;
        }


    }

    public ExpandShopGroup() {
    }

    public ExpandShopGroup(String shoppingID, String date, String name, ArrayList<shopItem> items) {
        this.shoppingID = shoppingID;
        this.date = date;
        this.name = name;
        Items = items;
    }

    public String getShoppinID() {
        return shoppingID;
    }

    public void setShoppinID(String shoppinID) {
        this.shoppingID = shoppinID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<shopItem> getItems() {
        return Items;
    }

    public void setItems(ArrayList<shopItem> items) {
        Items = items;
    }
}
