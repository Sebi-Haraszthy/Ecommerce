package com.Ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue
    private Long id;

}