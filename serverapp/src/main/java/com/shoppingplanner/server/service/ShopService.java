package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Shop;
import com.shoppingplanner.server.model.ShopDetail;
import com.shoppingplanner.server.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private ShopRepository repository;
    public Shop createShop(Shop shop) {
        for(ShopDetail detail : shop.getShopDetails()){
            detail.setShop(shop);
        }
        return repository.save(shop);
    }
}
