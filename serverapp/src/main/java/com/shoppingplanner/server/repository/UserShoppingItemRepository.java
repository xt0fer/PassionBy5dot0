package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.UserShoppingItem;
import org.springframework.data.repository.CrudRepository;

public interface UserShoppingItemRepository  extends CrudRepository<UserShoppingItem, Long> {
}
