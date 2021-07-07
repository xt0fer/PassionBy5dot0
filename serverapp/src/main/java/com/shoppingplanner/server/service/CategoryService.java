package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Category;
import com.shoppingplanner.server.model.ShoppingItem;
import com.shoppingplanner.server.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category createCategory(Category category) {
        for(ShoppingItem  item : category.getShoppingItems()){
            item.setCategory(category);
        }
        return repository.save(category);
    }

    public Iterable<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(Long id) {

        return repository.findById(id).get();
    }

    public Iterable<ShoppingItem> getAllShoppingItems(Long category_id) {
        System.out.println(category_id);
        Category category = repository.findById(category_id).get();
        return category.getShoppingItems();
    }
}
