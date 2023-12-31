package com.Ecommerce.service;

import com.Ecommerce.model.CartItem;
import com.Ecommerce.model.Order;
import com.Ecommerce.model.OrderItem;
import com.Ecommerce.model.User;
import com.Ecommerce.repository.OrderRepository;
import com.Ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService {
    private CartItemService cartItemService;
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderService(CartItemService cartItemService, OrderRepository orderRepository, UserRepository userRepository) {
        this.cartItemService = cartItemService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order placeOrder(Long user_id) {
        User foundUser = userRepository.findById(user_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        List<CartItem> userCartItems = foundUser.getCartItems();
        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        newOrder.setUser(foundUser);
        newOrder.setTotalPrice(cartItemService.computeTotalPrice(userCartItems));

        for (CartItem cartItem : userCartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder(newOrder);
            newOrder.getOrderItems().add(orderItem);
        }

        Order savedOrder = orderRepository.save(newOrder);
        cartItemService.deleteAllUserCartItems(user_id);

        return savedOrder;
    }

    public List<Order> getAllOrdersByUser(Long user_id) {
        User foundUser = userRepository.findById(user_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));

        return orderRepository.findAllByUserOrderByCreatedDateDesc(foundUser);
    }

    public Order getOrderDetails(Long order_id) {
        return orderRepository.findById(order_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }
}