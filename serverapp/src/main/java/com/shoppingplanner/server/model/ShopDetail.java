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

    @ManyToMany
    Set<User> users;

}
