package com.shoppingplanner.server.repository;

import com.shoppingplanner.server.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
