package com.nocountry.ecommerce.service;
import com.nocountry.ecommerce.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    public Order save(Order order);
    public void delete(Integer id_order);
    public Order findById(Integer id_order);
    public List<Order> findAll();

}