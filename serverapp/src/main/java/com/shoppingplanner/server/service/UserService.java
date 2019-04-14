package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Account;
import com.shoppingplanner.server.model.User;
import com.shoppingplanner.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public User isValidLogin(User user) {
        return repository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    public User createUser(User user) {
        user.setUserName(user.getUserName().toLowerCase());
        return repository.save(user);
    }

    public User setAccount(Long id, Account account) {
        User user = repository.findById(id).orElse(null);
        if(user!= null){
            user.setAccount(account);
            return repository.save(user);
        }
        return null;
    }
}
