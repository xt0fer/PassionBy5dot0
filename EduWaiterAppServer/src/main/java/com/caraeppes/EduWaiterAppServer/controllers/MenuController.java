package com.caraeppes.EduWaiterAppServer.controllers;

import com.caraeppes.EduWaiterAppServer.models.Menu;
import com.caraeppes.EduWaiterAppServer.services.MenuService;
import com.caraeppes.EduWaiterAppServer.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> findById(@PathVariable Long id){
        return new ResponseEntity<>(menuService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Menu>> findAll(){
        return new ResponseEntity<>(menuService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Menu> create(@RequestBody Menu menu){
        return new ResponseEntity<>(menuService.create(menu), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Menu> update(@RequestBody Menu menu, @PathVariable Long id){
        return new ResponseEntity<>(menuService.update(menu, id), HttpStatus.OK);
    }

    @PutMapping("/updateDescription/{description}")
    public ResponseEntity<Menu> updateDescription(@RequestBody Menu menu, @PathVariable String description){
        return new ResponseEntity<>(menuService.updateDescription(menu, description), HttpStatus.OK);
    }

    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<Menu> updateRestaurant(@RequestBody Menu menu, @PathVariable Long restaurantId){
        return new ResponseEntity<>(menuService.updateRestaurant(menu, restaurantId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(menuService.deleteById(id), HttpStatus.NOT_FOUND);
    }
}