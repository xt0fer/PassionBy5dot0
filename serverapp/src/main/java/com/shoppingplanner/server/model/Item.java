package com.shoppingplanner.server.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn
    private Category category;

    @ManyToMany(mappedBy = "shoppingList")
    private Set<Account> accountSet;
}
