package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.AccountShoppingItem;
import org.springframework.data.repository.CrudRepository;

public interface UserShoppingItemRepository  extends CrudRepository<AccountShoppingItem, Long> {
}
