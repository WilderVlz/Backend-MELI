package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
}
