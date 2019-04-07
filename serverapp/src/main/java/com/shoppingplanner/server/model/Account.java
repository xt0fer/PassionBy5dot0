package com.shoppingplanner.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String accountName;

    @OneToMany(cascade = CascadeType.ALL)
    Set<ShopDetail> registeredShops;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private Set<User> users;

    @OneToMany(mappedBy = "account")
    Set<AccountShoppingItem> shoppingList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Set<ShopDetail> getRegisteredShops() {
        return registeredShops;
    }

    public void setRegisteredShops(Set<ShopDetail> registeredShops) {
        this.registeredShops = registeredShops;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<AccountShoppingItem> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(Set<AccountShoppingItem> shoppingList) {
        this.shoppingList = shoppingList;
    }
}
