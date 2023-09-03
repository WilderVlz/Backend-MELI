package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.dto.OrderDto;
import com.nocountry.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDto orderDto;

    @Override
    @Transactional(readOnly=false)
    public Order save(Order order) {
        return orderDto.save(order);
    }

    @Override
    @Transactional (readOnly=false)
    public void delete(Integer id_order) {
        orderDto.deleteById(id_order);
    }

    @Override
    @Transactional (readOnly=false)
    public Order findById(Integer id_order) {
        return orderDto.findById((id_order)).orElse(null);
    }

    @Override
    @Transactional (readOnly=false)
    public List<Order> findAll() {
        return (List<Order>) orderDto.findAll();
    }
}
