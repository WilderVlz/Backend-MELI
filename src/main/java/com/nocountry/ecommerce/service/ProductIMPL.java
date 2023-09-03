package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductIMPL {
    public List<Product> getAllProducts();
    public Optional<Product> getProduct(Long id);
    public void deleteProduct(Long id);
    public Product updateProduct(Product product);

}
