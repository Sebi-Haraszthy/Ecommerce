package com.Ecommerce.service;

import com.Ecommerce.model.Category;
import com.Ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        Category foundCategory = categoryRepository.findByName(category.getName());

        if (foundCategory == null) {
            return categoryRepository.save(category);
        } else {
            throw new ResponseStatusException(HttpStatus.CREATED, "Category already exists!");
        }
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category category, Long id) {
        Category foundCategory = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The category you want to update does not exist!"));
        foundCategory.setDescription(category.getDescription());
        foundCategory.setName(category.getName());

        return categoryRepository.save(foundCategory);
    }
}