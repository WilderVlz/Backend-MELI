package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.model.Product;
import org.hibernate.event.spi.PreDeleteEvent;

import java.util.List;
import java.util.Optional;

public interface ProductIMPL {
    public Product saveProducts(Product product);
    public List<Product> listProduct();
    public Optional<Product> getProduct(Long id);
    public void deleteProduct(Long id);
    public Product updateProduct(Long id,Product product);

}
