package com.Ecommerce.DTO;

public class AddToCartDTO {
    private Long product_id;
    private Long user_id;
    private Integer quantity;

    public AddToCartDTO(Long product_id, Long user_id, Integer quantity) {
        this.product_id = product_id;
        this.user_id = user_id;
        this.quantity = quantity;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}