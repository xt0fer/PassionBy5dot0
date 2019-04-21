package com.shoppingplanner.server.model;

import javax.persistence.*;
import java.util.Objects;
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
    private Account activeAccount;

    @ManyToMany
    private Set<Account> accounts;

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public User() {
    }

    public User(String userName, String password, Long id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void addToAccounts(Account account) {
        if(!accounts.contains(account)) {
            accounts.add(account);
        }
        if(activeAccount == null){
            activeAccount = account;
        }
    }
}
