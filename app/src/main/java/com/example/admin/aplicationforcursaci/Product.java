package com.example.admin.aplicationforcursaci;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 06.01.2019.
 */

public class Product {
    public static List<Product> products = new ArrayList<>(100);
    public static List<Product> orders = new ArrayList<>(10);
    public static Map<Integer, Integer> keys = new HashMap<Integer, Integer>(100);
    private Drawable image;
    private String productName;
    private String price;
    private int productId;

    Product(){

       image=null;
        productName="";
        price="0";
        productId=0;

    }

    public Product (int productId,Drawable image,String productName,String price){
        this.image=image;
        this.productName=productName;
        this.price=price;
        this.productId=productId;

    }



    public Drawable getImage(){
        return image;
    }

    public String getPrice(){
        return price;
    }

    public String getProductName(){
        return productName;
    }
    public int getProductId(){
        return productId;
    }





}
