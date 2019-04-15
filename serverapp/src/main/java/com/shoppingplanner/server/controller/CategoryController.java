package com.shoppingplanner.server.controller;

import com.shoppingplanner.server.model.Category;
import com.shoppingplanner.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/category/")
    @CrossOrigin
    public Category createCategory(@RequestBody Category category){
        return service.createCategory(category);
    }

    @GetMapping("/category/")
    @CrossOrigin
    public Iterable<Category> getAllCategories(){
        return service.getAllCategories();
    }

}
