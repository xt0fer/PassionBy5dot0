package com.shoppingplanner.server.model;

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

    @OneToMany(mappedBy = "account")
    private Set<User> users;

    @OneToMany(mappedBy = "account")
    Set<AccountShoppingItem> shoppingList;
}
