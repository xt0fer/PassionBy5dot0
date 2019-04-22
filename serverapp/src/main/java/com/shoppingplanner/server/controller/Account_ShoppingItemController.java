package com.shoppingplanner.server.controller;

import com.shoppingplanner.server.model.Account;
import com.shoppingplanner.server.model.Account_ShoppingItem;
import com.shoppingplanner.server.model.ShoppingItem;
import com.shoppingplanner.server.service.AccountService;
import com.shoppingplanner.server.service.Account_ShoppingItemService;
import com.shoppingplanner.server.service.ShoppingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Account_ShoppingItemController {
    @Autowired
    Account_ShoppingItemService service;

    @PostMapping("/account/{account_id}/shoppingitem/{shoppingItem_id}")

    public Account_ShoppingItem createShoppingItem(@PathVariable Long account_id,
                                                     @PathVariable Long shoppingItem_id,
                                                     @RequestBody Account_ShoppingItem account_shoppingItem){
        System.out.println(account_id +" "+ shoppingItem_id + " " + account_shoppingItem.getNote());
        return service.createShoppingItem(account_id, shoppingItem_id, account_shoppingItem);
    }

    @GetMapping("/account/{account_id}/shoppingitem/all")
    public Iterable<Account_ShoppingItem> getAllShoppingItemsForAccount(@PathVariable Long account_id){
        System.out.println("********"+account_id + " ****");
        return service.getAllShoppingItemsForAccount(account_id);
    }
    @DeleteMapping("/account/shoppingitem/{account_ShoppingItemId}")
    public void deleteAccountShoppingItem(@PathVariable Long account_ShoppingItemId){
        System.out.println("******** "+ account_ShoppingItemId + " ****");
        service.deleteAccountShoppingItem(account_ShoppingItemId);
    }
}
