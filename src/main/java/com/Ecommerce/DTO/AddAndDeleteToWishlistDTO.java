package com.Ecommerce.DTO;

public class AddAndDeleteToWishlistDTO {
    private Long product_id;
    private Long user_id;

    public AddAndDeleteToWishlistDTO(Long product_id, Long user_id) {
        this.product_id = product_id;
        this.user_id = user_id;
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
}