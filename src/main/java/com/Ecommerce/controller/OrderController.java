package com.Ecommerce.controller;

import com.Ecommerce.model.Order;
import com.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create/{user_id}")
    public Order addOrder(@PathVariable Long user_id) {
        return orderService.placeOrder(user_id);
    }

    @GetMapping("/{user_id}")
    public List<Order> getAllOrdersByUser(Long user_id) {
        return orderService.getAllOrdersByUser(user_id);
    }

    @GetMapping("/details/{order_id}")
    public Order getOrderDetails(@PathVariable Long order_id) {
        return orderService.getOrderDetails(order_id);
    }
}