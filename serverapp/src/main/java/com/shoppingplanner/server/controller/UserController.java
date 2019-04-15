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
    @CrossOrigin
    public ResponseEntity<User> isValidLogin(@RequestBody User user){
        System.out.println("*********"+user.getPassword()+ " "+ user.getUserName());
        User returnedUser = service.isValidLogin(user);
        return new ResponseEntity<>(returnedUser, (returnedUser == null) ?
                                                HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @PostMapping("/user/")
    @CrossOrigin
    public ResponseEntity<User> createUser(@RequestBody User user){
        User returnedUser = service.createUser(user);
        return new ResponseEntity<>(returnedUser, (returnedUser == null) ?
                HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @PutMapping("/user/account/{id}")
    public ResponseEntity<User> setAccountForUser(@PathVariable Long id, @RequestBody Account account){
        User returnedUser =  service.setAccount(id, account);
        return new ResponseEntity<>(returnedUser, (returnedUser == null) ?
                HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

}
