package com.shoppingplanner.server.controller;

import com.shoppingplanner.server.model.ShoppingItem;
import com.shoppingplanner.server.service.ShoppingItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
