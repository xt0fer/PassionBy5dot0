package com.shoppingplanner.server.model;

import javax.persistence.*;

@Entity
public class AccountShoppingItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    Account account;

    @ManyToOne
    @JoinColumn
    Item shoppingItem;

    @ManyToOne
    @JoinColumn
    ShopDetail prefferedShop;
}
