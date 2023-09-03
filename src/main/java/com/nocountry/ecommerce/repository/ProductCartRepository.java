package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.model.ProductCart;
import org.springframework.data.repository.CrudRepository;

public interface ProductCartRepository extends CrudRepository<ProductCart, Integer> {

}
