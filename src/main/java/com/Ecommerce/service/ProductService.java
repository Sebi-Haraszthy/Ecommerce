package com.Ecommerce.service;

import com.Ecommerce.DTO.AddProductDTO;
import com.Ecommerce.model.Category;
import com.Ecommerce.model.Product;
import com.Ecommerce.repository.CategoryRepository;
import com.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Product addProduct(AddProductDTO addProductDTO, Long categoryId) {
        Product productToBeSaved = new Product();
        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The category you want to update does not exist!"));
        productToBeSaved.setCategory(foundCategory);
        productToBeSaved.setDescription(addProductDTO.getDescription());
        productToBeSaved.setName(addProductDTO.getName());
        productToBeSaved.setPrice(addProductDTO.getPrice());

        return productRepository.save(productToBeSaved);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(Long categoryId) {
        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The category you want to update does not exist!"));

        return productRepository.findAllByCategory(foundCategory);
    }

    public Product updateProduct(AddProductDTO addProductDTO, Long productId) {
        Product foundProduct = productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The product you want to update does not exist!"));
        Category foundCategory = categoryRepository.findById(addProductDTO.getCategoryId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The category does not exist!"));
        foundProduct.setName(addProductDTO.getName());
        foundProduct.setDescription(addProductDTO.getDescription());
        foundProduct.setPrice(addProductDTO.getPrice());
        foundProduct.setCategory(foundCategory);

        return productRepository.save(foundProduct);
    }
}