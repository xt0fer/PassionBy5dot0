package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Category;
import com.shoppingplanner.server.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public Iterable<Category> getAllCategories() {
        return repository.findAll();
    }
}
