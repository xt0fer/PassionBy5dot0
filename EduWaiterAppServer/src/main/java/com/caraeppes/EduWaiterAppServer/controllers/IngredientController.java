package com.caraeppes.EduWaiterAppServer.controllers;

import com.caraeppes.EduWaiterAppServer.models.Ingredient;
import com.caraeppes.EduWaiterAppServer.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient){
        return new ResponseEntity<>(ingredientService.create(ingredient), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> findAll(){
        return new ResponseEntity<>(ingredientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable Long id){
        return new ResponseEntity<>(ingredientService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ingredient> update(@RequestBody Ingredient ingredient, @PathVariable Long id){
        return new ResponseEntity<>(ingredientService.update(ingredient, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(ingredientService.deleteById(id), HttpStatus.NOT_FOUND);
    }
}
