package com.Ecommerce.controller;

import com.Ecommerce.DTO.AddToCartDTO;
import com.Ecommerce.DTO.UserCartDTO;
import com.Ecommerce.model.CartItem;
import com.Ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{user_id}")
    public UserCartDTO viewCart(@PathVariable Long user_id) {
        return cartItemService.viewCart(user_id);
    }

    @DeleteMapping("/delete/{cartItem_id}")
    public void deleteCartItem(@PathVariable Long cartItem_id) {
        cartItemService.deleteCartItem(cartItem_id);
    }
}