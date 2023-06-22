package com.Ecommerce.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<CartItem> cartItems;
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Wishlist wishlist;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

//    public Wishlist getWishlist() {
//        return wishlist;
//    }
//
//    public void setWishlist(Wishlist wishlist) {
//        this.wishlist = wishlist;
//    }

    @Override
    public String toString() {
        return "User: " + "id = " + id + "; name = " + name + "; cartItems = " + cartItems + "; wishlist = " + ".";
    }
}