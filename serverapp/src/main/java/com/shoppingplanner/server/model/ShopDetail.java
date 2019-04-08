package com.shoppingplanner.server.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShopDetail {
    @Id
    @GeneratedValue
    private Long id;
    private String address;


    @ManyToMany
    Set<Account> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
