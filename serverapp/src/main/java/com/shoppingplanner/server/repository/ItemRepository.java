package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository  extends CrudRepository<Item, Long> {
}
