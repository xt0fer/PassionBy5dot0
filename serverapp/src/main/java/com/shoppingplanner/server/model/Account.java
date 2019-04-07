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

    @OneToMany(mappedBy = "account")
    private Set<User> users;
}
