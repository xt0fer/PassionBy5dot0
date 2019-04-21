package com.caraeppes.EduWaiterAppServer.controllers;

import com.caraeppes.EduWaiterAppServer.models.AdminAccount;
import com.caraeppes.EduWaiterAppServer.services.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/admin")
public class AdminAccountController {

    private AdminAccountService adminAccountService;

    @Autowired
    public AdminAccountController(AdminAccountService adminAccountService) {
        this.adminAccountService = adminAccountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminAccount> findById(@PathVariable Long id) {
        return new ResponseEntity<>(adminAccountService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AdminAccount>> findAll() {
        return new ResponseEntity<>(adminAccountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AdminAccount> findByUsername(@PathVariable String username){
        return new ResponseEntity<>(adminAccountService.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdminAccount> create(@RequestBody AdminAccount adminAccount) {
        return new ResponseEntity<>(adminAccountService.create(adminAccount), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<AdminAccount> update(@RequestBody AdminAccount adminAccount, @PathVariable Long id) {
        return new ResponseEntity<>(adminAccountService.update(adminAccount, id), HttpStatus.OK);
    }

    @PutMapping("{id}/updateRestaurant")
    private ResponseEntity<AdminAccount> updateRestaurant(@PathVariable Long id, @RequestParam Long restaurantId){
        return new ResponseEntity<>(adminAccountService.updateRestaurant(id, restaurantId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(adminAccountService.deleteById(id), HttpStatus.NOT_FOUND);
    }
}
