package com.caraeppes.EduWaiterAppServer.services;

import com.caraeppes.EduWaiterAppServer.models.Ingredient;
import com.caraeppes.EduWaiterAppServer.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient create(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findById(Long id){
        return ingredientRepository.getOne(id);
    }

    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Ingredient update(Ingredient ingredient, Long id){
        Ingredient original = ingredientRepository.getOne(id);
        original.setName(ingredient.getName());
        original.setMenuItems(ingredient.getMenuItems());
        original.setAllergen(ingredient.getAllergen());
        return ingredientRepository.save(original);
    }

    public Boolean deleteById(Long id){
        ingredientRepository.deleteById(id);
        return true;
    }
}
