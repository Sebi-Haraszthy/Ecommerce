package com.Ecommerce.DTO;

import com.Ecommerce.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class UserCartDTO {
    private List<CartItem> cartItems;
    private Double totalPrice;

    public UserCartDTO(List<CartItem> cartItems, Double totalPrice) {
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
    }

    public UserCartDTO() {
    }

    public List<CartItem> getCartItems() {
        if (this.cartItems == null) {
            this.cartItems = new ArrayList<>();
        }

        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}