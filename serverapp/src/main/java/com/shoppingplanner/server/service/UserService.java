package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Account;
import com.shoppingplanner.server.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean isValidLogin() {
        return false;
    }

    public User createUser(User user) {
        return null;
    }

    public User setAccount(Long id, Account account) {
        return null;
    }
}
