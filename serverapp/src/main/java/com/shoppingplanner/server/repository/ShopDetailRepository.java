package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.ShopDetail;
import org.springframework.data.repository.CrudRepository;

public interface ShopDetailRepository  extends CrudRepository<ShopDetail, Long> {
}
