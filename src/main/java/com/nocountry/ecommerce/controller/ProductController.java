package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.dto.CustomerLoginResponse;
import com.nocountry.ecommerce.dto.Mensaje;
import com.nocountry.ecommerce.dto.ProductDto;
import com.nocountry.ecommerce.model.Account;
import com.nocountry.ecommerce.model.Product;
import com.nocountry.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("listar")
    public ResponseEntity<List<Product>> getAll(){
        List<Product>listProducts = productService.listProduct();
        return new ResponseEntity<>(listProducts, HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<?> crearProduct(@RequestBody Product product){


        return new ResponseEntity<>(productService.saveProducts(product), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product productDto){
        try{
            if(id == null){
                return new ResponseEntity<>(new Mensaje("Id can't be null"), HttpStatus.INTERNAL_SERVER_ERROR);
            }else{
                if(productService.getProduct(id).isPresent()){
                    return new ResponseEntity<>(productService.updateProduct(id,productDto), HttpStatus.OK);
                }
                return new ResponseEntity<>(new Mensaje("Product not found"), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new Mensaje(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
