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
    @OneToMany(mappedBy = "activeAccount")
    private Set<User> actievUsers;

    @JsonIgnore
    @ManyToMany(mappedBy = "accounts")
    private Set<User> users;

    @OneToMany(mappedBy = "account")
    private Set<Account_ShoppingItem> shoppingItems;

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

    public Set<Account_ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(Set<Account_ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    public Set<User> getActievUsers() {
        return actievUsers;
    }

    public void setActievUsers(Set<User> actievUsers) {
        this.actievUsers = actievUsers;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
