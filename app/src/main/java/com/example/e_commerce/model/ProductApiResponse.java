package com.example.e_commerce.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductApiResponse {

    @SerializedName("products")
    private List<Product> products;

    public List<com.example.e_commerce.model.Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
