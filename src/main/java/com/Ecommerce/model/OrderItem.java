package com.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    private Integer quantity;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem: " + "id = " + id + "; quantity = " + quantity + "; order = " + order + "; product = " + product + ".";
    }
}