package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
