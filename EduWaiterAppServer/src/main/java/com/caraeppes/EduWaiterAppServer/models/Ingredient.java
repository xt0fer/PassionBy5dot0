package com.caraeppes.EduWaiterAppServer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="allergen")
    private Boolean allergen;
    @ManyToMany(mappedBy="ingredients")
    private List<MenuItem> menuItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAllergen() {
        return allergen;
    }

    public void setAllergen(Boolean allergen) {
        this.allergen = allergen;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
