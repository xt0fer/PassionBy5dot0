package com.shoppingplanner.server.controller;

import com.shoppingplanner.server.model.Account;
import com.shoppingplanner.server.model.User;
import com.shoppingplanner.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping("/user/checklogin")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<User> isValidLogin(@RequestBody User user){
        System.out.println("*********"+user.getPassword()+ " "+ user.getUserName());
        User returnedUser = service.isValidLogin(user);
        return new ResponseEntity<>(returnedUser, (returnedUser == null) ?
                                                HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping("/user/")
    @CrossOrigin(origins = "http://localhost:8100")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @PutMapping("/user/account/{id}")
    public User createUser(@PathVariable Long id, @RequestBody Account account){
        return service.setAccount(id, account);
    }

}
