package com.nocountry.ecommerce.dto;

import com.nocountry.ecommerce.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDto extends CrudRepository<Order, Integer> {
}