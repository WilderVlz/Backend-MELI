package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.model.Product;
import com.nocountry.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product>listProducts = productService.getAllProducts();
        return new ResponseEntity<>(listProducts, HttpStatus.OK);
    }

}
