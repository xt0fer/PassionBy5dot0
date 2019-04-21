package com.shoppingplanner.server.service;

import com.shoppingplanner.server.model.Account;
import com.shoppingplanner.server.model.User;
import com.shoppingplanner.server.repository.AccountRepository;
import com.shoppingplanner.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;
    private AccountRepository accountRepository;
    public User isValidLogin(User user) {
        user.setUserName(user.getUserName().toLowerCase());
        return repository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    public User createUser(User user) {
        user.setUserName(user.getUserName().toLowerCase());
        return repository.save(user);
    }

    public User addAccount(Long id, Long accountId) {
        Account accRetrieved = accountRepository.findById(accountId).get();
        User user = repository.findById(id).orElse(null);
        if(user!= null){
            user.addToAccounts(accRetrieved);
            return repository.save(user);
        }
        return null;
    }

    @Autowired
    public UserService(UserRepository repository, AccountRepository accountRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    public User setActiveAccount(Long userId, Long accountId) {
        Account accRetrieved = accountRepository.findById(accountId).get();
        User user = repository.findById(userId).orElse(null);
        if(user!= null){
            user.addToAccounts(accRetrieved);
            user.setActiveAccount(accRetrieved);
            return repository.save(user);
        }
        return null;
    }
}
