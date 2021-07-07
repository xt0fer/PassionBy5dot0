package com.shoppingplanner.server.controller;

import com.shoppingplanner.server.model.Shop;
import com.shoppingplanner.server.model.User;
import com.shoppingplanner.server.service.ShopService;
import com.shoppingplanner.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    private ShopService service;


    @PostMapping("/shop/")
    public Shop createUser(@RequestBody Shop shop){
        return service.createShop(shop);
    }
}
