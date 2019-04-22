package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Category;
import com.shoppingplanner.server.model.ShoppingItem;
import com.shoppingplanner.server.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingItemService {
    @Autowired
    ShoppingItemRepository repository;

    public Iterable<ShoppingItem> getAllShoppingItems() {
        return repository.findAllByNameNotIn("Miscellaneous", "Other");
    }
    public ShoppingItem getShoppingItem(Long shoppingId){
        return repository.findById(shoppingId).get();
    }
}
