package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Account;
import com.shoppingplanner.server.model.Account_ShoppingItem;
import com.shoppingplanner.server.model.ShoppingItem;
import com.shoppingplanner.server.repository.Account_ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Account_ShoppingItemService {
    @Autowired
    AccountService accountService;
    @Autowired
    ShoppingItemService shoppingItemService;

    @Autowired
    Account_ShoppingItemRepository account_shoppingItemRepository;

    public Account_ShoppingItem createShoppingItem(Long account_id,
                                                   Long shoppingItem_id,
                                                   Account_ShoppingItem account_shoppingItem){

        Account account = accountService.getAccount(account_id);
        ShoppingItem shoppingItem = shoppingItemService.getShoppingItem(shoppingItem_id);
        account_shoppingItem.setAccount(account);
        account_shoppingItem.setShoppingItem(shoppingItem);
        return account_shoppingItemRepository.save(account_shoppingItem);
    }

    public Iterable<Account_ShoppingItem> getAllShoppingItemsForAccount(Long account_id) {
        return account_shoppingItemRepository.findAllByAccount_Id(account_id);
    }
    public void deleteAccountShoppingItem(Long account_ShoppingItemId) {
        account_shoppingItemRepository.deleteById(account_ShoppingItemId);
    }

}
