package com.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class WishlistItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id")
    private Product product;

    public WishlistItem() {
    }

    public Long getId() {
        return id;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "WishlistItem: " + "id = " + id + "; wishlist = " + wishlist + "; product = " + product + ".";
    }
}