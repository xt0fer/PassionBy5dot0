package com.caraeppes.EduWaiterAppServer.models;

import com.caraeppes.EduWaiterAppServer.utilities.MenuItemSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long id;
    @Column(name = "menu_name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(
            name="menu_menu_items",
            joinColumns=@JoinColumn(name="menu_id", referencedColumnName="menu_id"),
            inverseJoinColumns=@JoinColumn(name="menu_item_id", referencedColumnName = "menu_item_id"))
    @JsonSerialize(using = MenuItemSerializer.class)
    private List<MenuItem> menuItems;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    @JsonIgnoreProperties(value = "menus", allowSetters=true)
    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(String name, String description, List<MenuItem> menuItems, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.menuItems = menuItems;
        this.restaurant = restaurant;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
