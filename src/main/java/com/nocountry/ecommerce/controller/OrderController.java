package com.nocountry.ecommerce.controller;
import com.nocountry.ecommerce.service.OrderServiceImpl;
import com.nocountry.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")

public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @PostMapping(value = "/")
    public ResponseEntity<Order> agregar(@RequestBody Order order) {
        Order orderObj = orderServiceImpl.save(order);
        return new ResponseEntity<>(orderObj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delOrder/{order_Id}")
    public ResponseEntity<Order> eliminar(@PathVariable Integer orderId) {
        Order orderObj = orderServiceImpl.findById(orderId);
        if (orderObj != null) {
            orderServiceImpl.delete(orderId);
        } else {
            return new ResponseEntity<>(orderObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(orderObj, HttpStatus.OK);
    }

    @PutMapping(value = "/editOrder/{order_Id}")
    public ResponseEntity<Order> editOrder(@RequestBody Order order) {
        Order orderObj = orderServiceImpl.findById(Integer.parseInt(order.getOrderId().toString()));
        if (orderObj != null) {
            orderObj.setTotal(order.getTotal());
            orderObj.setOrderDate(order.getOrderDate());
            orderObj.setShippingAddress(order.getShippingAddress());
            orderObj.setDescription(order.getDescription());
            orderObj.setPaymentMethod(order.getPaymentMethod());
            orderServiceImpl.save(orderObj);
        } else {
            return new ResponseEntity<>(orderObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(orderObj, HttpStatus.OK);
    }

    @GetMapping("/ordersList")
    public List<Order> listAll() {
        return orderServiceImpl.findAll();
    }

    @GetMapping("/orders/{order_Id}")
    public ResponseEntity<Order> orderById(@PathVariable Integer orderId) {
        Order order = orderServiceImpl.findById(orderId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

