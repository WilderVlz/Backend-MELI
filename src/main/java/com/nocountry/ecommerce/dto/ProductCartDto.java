package com.nocountry.ecommerce.dto;

import com.nocountry.ecommerce.model.Product;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ProductCartDto {

    private Long productId;
    private List<Product> productName;
    private int quantity;
    private double price;

    public ProductCartDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<Product> getProductName() {
        return productName;
    }

    public void setProductName(List<Product> productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
