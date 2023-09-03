package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.dto.ProductCartDto;
import com.nocountry.ecommerce.model.Product;

import java.util.LinkedList;

public interface ProductCartService {
    void addProduct(Product product) throws Exception;

    void removeProduct(Long product);

    LinkedList<ProductCartDto> viewCartProducts();
}
