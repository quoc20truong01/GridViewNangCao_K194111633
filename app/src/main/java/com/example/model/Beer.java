package com.example.model;

public class Beer {
    private int productThumb;
    private String productName;
    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductThumb() {
        return productThumb;
    }

    public String getProductName() {
        return productName;
    }

    public Beer(int productThumb, String productName) {
        this.productThumb = productThumb;
        this.productName = productName;
    }
}
