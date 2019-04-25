package com.caraeppes.EduWaiterAppServer.controllers;

import com.caraeppes.EduWaiterAppServer.models.Restaurant;
import com.caraeppes.EduWaiterAppServer.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long id){
        return new ResponseEntity<>(restaurantService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> findAll(){
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant){
        return new ResponseEntity<>(restaurantService.create(restaurant), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Restaurant> update(@RequestBody Restaurant restaurant, @PathVariable Long id){
        return new ResponseEntity<>(restaurantService.update(restaurant, id), HttpStatus.OK);
    }

    @PutMapping("/addAdmin/{adminId}")
    public ResponseEntity<Restaurant> addAdmin(@RequestBody Restaurant restaurant, @PathVariable Long adminId){
        return new ResponseEntity<>(restaurantService.addAdmin(restaurant, adminId), HttpStatus.OK);
    }

    @PutMapping("/addEmployee/{employeeId}")
    public ResponseEntity<Restaurant> addEmployee(@RequestBody Restaurant restaurant, @PathVariable Long employeeId){
        return new ResponseEntity<>(restaurantService.addEmployee(restaurant, employeeId), HttpStatus.OK);
    }

    @PutMapping("/addMenu/{menuId}")
    public ResponseEntity<Restaurant> addMenu(@RequestBody Restaurant restaurant, @PathVariable Long menuId){
        return new ResponseEntity<>(restaurantService.addMenu(restaurant, menuId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(restaurantService.deleteById(id), HttpStatus.NOT_FOUND);
    }


}
