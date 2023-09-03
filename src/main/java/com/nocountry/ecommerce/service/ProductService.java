package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.model.Product;
import com.nocountry.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductIMPL{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
}
