package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
