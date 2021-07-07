package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.Category;
import com.shoppingplanner.server.model.ShoppingItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    public Iterable<ShoppingItem> findAllByNameNotIn(String... name);
}
