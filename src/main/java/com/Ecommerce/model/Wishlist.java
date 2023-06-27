package com.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int quantity;
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "wishlist", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    List<WishlistItem> wishlistItems;

    public Wishlist() {
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Wishlist: " + "id = " + id + "; quantity = " + quantity + "; user = " + user + "; wishlistItems = " + wishlistItems + ".";
    }
}