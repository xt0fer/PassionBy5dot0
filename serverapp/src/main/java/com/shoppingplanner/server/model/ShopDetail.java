package com.shoppingplanner.server.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShopDetail {
    @Id
    @GeneratedValue
    private Long id;
    private String address;

    @ManyToOne
    @JoinColumn
    private Shop shop;


    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

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

//    public Set<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(Set<Account> accounts) {
//        this.accounts = accounts;
//    }
}
