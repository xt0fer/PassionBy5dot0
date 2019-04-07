package com.shoppingplanner.server.model;

import javax.persistence.*;

@Entity
public class UserShoppingItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Item shoppingItem;

    @ManyToOne
    @JoinColumn
    ShopDetail prefferedShop;
}
