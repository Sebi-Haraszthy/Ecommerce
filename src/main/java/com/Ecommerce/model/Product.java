package com.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;
    @ManyToOne
    @JsonBackReference("productList")
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    List<CartItem> cartItems;
    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<OrderItem> orderItems;
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    List<WishlistItem> wishlistItems;

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<OrderItem> getOrderItems() {
        if (this.orderItems == null) {
            this.orderItems = new ArrayList<>();
        }

        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<WishlistItem> getWishlistItems() {
        if (this.wishlistItems == null) {
            this.wishlistItems = new ArrayList<>();
        }

        return wishlistItems;
    }

    public void setWishlistItems(List<WishlistItem> wishlistItems) {
        this.wishlistItems = wishlistItems;
    }

    @Override
    public String toString() {
        return "Product: " + "id = " + id + "; name = " + name + "; description = " + description + "; price = " + price + "; category = " + category + "; cartItems = " + cartItems + "; orderItems = " + orderItems + "; wishlistItems = " + wishlistItems + ".";
    }
}