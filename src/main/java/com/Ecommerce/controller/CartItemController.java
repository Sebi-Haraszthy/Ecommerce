package com.Ecommerce.controller;

import com.Ecommerce.DTO.AddToCartDTO;
import com.Ecommerce.model.CartItem;
import com.Ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartItemController {
    private CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/create")
    public CartItem addToCart(@RequestBody AddToCartDTO addToCartDTO) {
        return cartItemService.addToCart(addToCartDTO);
    }
}