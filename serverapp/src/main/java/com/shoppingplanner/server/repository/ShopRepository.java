package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository  extends CrudRepository<Shop, Long> {
}
