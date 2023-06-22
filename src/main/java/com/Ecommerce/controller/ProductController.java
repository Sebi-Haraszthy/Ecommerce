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
    public Product addProduct(@RequestBody AddProductDTO addProductDTO) {
        Long categoryId = addProductDTO.getCategoryId();

        return productService.addProduct(addProductDTO, categoryId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{category_id}")
    public List<Product> getAllProductsByCategory(@PathVariable Long categoryId) {
        return productService.getAllProductsByCategory(categoryId);
    }

    @PutMapping("/update/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long productId) {
        return productService.
    }
}