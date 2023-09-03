package com.nocountry.ecommerce.controller;
import com.nocountry.ecommerce.dto.ProductCartDto;
import com.nocountry.ecommerce.model.Product;
import com.nocountry.ecommerce.service.ProductCartService;
import com.nocountry.ecommerce.service.implementation.ProductCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/cart")
public class ProductCartController{
    private final ProductCartServiceImpl cartService;

    @Autowired
    public ProductCartController(ProductCartService cartService) {
        this.cartService = (ProductCartServiceImpl) cartService;
    }

    @PutMapping("/add")
    public void addToCart(@RequestBody Product product) throws Exception {
        cartService.addProduct(product);
    }

    @DeleteMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable Long productId) {
        cartService.removeProduct(productId);
    }

    @GetMapping("/view")
    public LinkedList<ProductCartDto> viewCart() {
        return cartService.viewCartProducts();
    }
}