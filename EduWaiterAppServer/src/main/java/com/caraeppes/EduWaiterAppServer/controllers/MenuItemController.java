package com.caraeppes.EduWaiterAppServer.controllers;

import com.caraeppes.EduWaiterAppServer.models.MenuItem;
import com.caraeppes.EduWaiterAppServer.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuItems")
public class MenuItemController {

    private MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public ResponseEntity<MenuItem> create(@RequestBody MenuItem menuItem){
        return new ResponseEntity<>(menuItemService.create(menuItem), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> findById(@PathVariable Long id){
        return new ResponseEntity<>(menuItemService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> findAll(){
        return new ResponseEntity<>(menuItemService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MenuItem> update(@RequestBody MenuItem menuItem, @PathVariable Long id){
        return new ResponseEntity<>(menuItemService.update(menuItem, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(menuItemService.deleteById(id), HttpStatus.NOT_FOUND);
    }

}

