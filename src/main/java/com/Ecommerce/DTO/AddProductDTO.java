package com.Ecommerce.DTO;

public class AddProductDTO {
    private String name;
    private Double price;
    private String description;
    private Long category_id;

    public AddProductDTO(String name, Double price, String description, Long category_id) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}