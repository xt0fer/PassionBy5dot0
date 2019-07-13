package com.caraeppes.EduWaiterAppServer.controllers;

import com.caraeppes.EduWaiterAppServer.models.EmployeeAccount;
import com.caraeppes.EduWaiterAppServer.models.Restaurant;
import com.caraeppes.EduWaiterAppServer.repositories.RestaurantRepository;
import com.caraeppes.EduWaiterAppServer.services.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/employees")
public class EmployeeAccountController {

    private EmployeeAccountService employeeAccountService;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public EmployeeAccountController(EmployeeAccountService employeeAccountService,
                                     RestaurantRepository restaurantRepository) {
        this.employeeAccountService = employeeAccountService;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeAccount> findById(@PathVariable Long id){
        return new ResponseEntity<>(employeeAccountService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeAccount>> findAll(){
        return new ResponseEntity<>(employeeAccountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<EmployeeAccount> findByUsername(@PathVariable String username){
        return new ResponseEntity<>(employeeAccountService.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeAccount> create(@RequestBody EmployeeAccount employeeAccount){
        return new ResponseEntity<>(employeeAccountService.create(employeeAccount), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeAccount> update(@RequestBody EmployeeAccount employeeAccount, @PathVariable Long id){
        return new ResponseEntity<>(employeeAccountService.update(employeeAccount, id), HttpStatus.OK);
    }

    @PutMapping("{id}/updateRestaurant")
    public ResponseEntity<EmployeeAccount> updateRestaurant(@RequestParam Long restaurantId, @PathVariable Long id){
        return new ResponseEntity<>(employeeAccountService.updateRestaurant(restaurantId, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(employeeAccountService.deleteById(id), HttpStatus.NOT_FOUND);
    }

}
