package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
}
