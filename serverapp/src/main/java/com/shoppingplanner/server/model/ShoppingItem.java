package com.shoppingplanner.server.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShoppingItem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "shoppingItem")
    Set<Account_ShoppingItem> account_shoppingItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Account_ShoppingItem> getAccount_shoppingItems() {
        return account_shoppingItems;
    }

    public void setAccount_shoppingItems(Set<Account_ShoppingItem> account_shoppingItems) {
        this.account_shoppingItems = account_shoppingItems;
    }
}
