package com.shoppingplanner.server.controller;

import com.shoppingplanner.server.model.Category;
import com.shoppingplanner.server.model.ShoppingItem;
import com.shoppingplanner.server.service.CategoryService;
import com.shoppingplanner.server.service.ShoppingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingItemController {
    @Autowired
    private ShoppingItemService shoppingItemService;


    @GetMapping("/shoppingitem/all")
    @CrossOrigin
    public Iterable<ShoppingItem> getAllShoppingItemsForCategory(){
        return shoppingItemService.getAllShoppingItems();
    }

}
