package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productId;
    private String display;
    private String description ;
    private int priceOut;
    private int priceIn;
    private int priceSale;
    private String imageUrl;
    private int instock;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", display='" + display + '\'' +
                ", description='" + description + '\'' +
                ", priceOut=" + priceOut +
                ", priceIn=" + priceIn +
                ", priceSale=" + priceSale +
                ", imageUrl='" + imageUrl + '\'' +
                ", instock=" + instock +
                '}';
    }
}
