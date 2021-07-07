package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.Account_ShoppingItem;
import org.springframework.data.repository.CrudRepository;

public interface Account_ShoppingItemRepository
        extends CrudRepository<Account_ShoppingItem, Long> {
    public Iterable<Account_ShoppingItem>
    findAllByAccount_Id(Long accountID);
}
