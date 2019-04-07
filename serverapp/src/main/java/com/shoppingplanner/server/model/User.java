package com.shoppingplanner.server.model;

import com.shoppingplanner.server.model.modelenum.AccountType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String password;
    private AccountType accountType;

    @ManyToOne
    @JoinColumn
    private Account account;


}
