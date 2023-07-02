package com.Ecommerce.controller;

import com.Ecommerce.DTO.AddProductDTO;
import com.Ecommerce.model.Product;
import com.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public void addProduct(@RequestBody AddProductDTO addProductDTO) {
        Long categoryId = addProductDTO.getCategoryId();
        productService.addProduct(addProductDTO, categoryId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{category_id}")
    public List<Product> getAllProductsByCategory(@PathVariable Long category_id) {
        return productService.getAllProductsByCategory(category_id);
    }

    @PutMapping("/update/{product_id}")
    public Product updateProduct(@RequestBody AddProductDTO addProductDTO, @PathVariable Long product_id) {
        return productService.updateProduct(addProductDTO, product_id);
    }

    @DeleteMapping("/delete/{product_id}")
    public void deleteProductFromCategory(@PathVariable Long product_id) {
        productService.deleteProduct(product_id);
    }
}