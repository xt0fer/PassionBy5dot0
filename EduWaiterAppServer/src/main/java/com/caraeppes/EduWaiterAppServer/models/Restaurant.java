package com.caraeppes.EduWaiterAppServer.models;

import com.caraeppes.EduWaiterAppServer.utilities.AdminSerializer;
import com.caraeppes.EduWaiterAppServer.utilities.EmployeeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "restaurant")
    @JsonIgnoreProperties(value = "restaurant", allowSetters=true)
    private List<Menu> menus;
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnoreProperties(value = "restaurant")
    private List<AdminAccount> admin;
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnoreProperties(value = "restaurant")
    private List<EmployeeAccount> employees;
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnoreProperties(value = "restaurant")
    private List<Fact> facts;

    public Restaurant() {
        menus = new ArrayList<>();
        admin = new ArrayList<>();
        employees = new ArrayList<>();
        facts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<AdminAccount> getAdmin() {
        return admin;
    }

    public void setAdmin(List<AdminAccount> admin) {
        this.admin = admin;
    }

    public List<EmployeeAccount> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeAccount> employees) {
        this.employees = employees;
    }

    public List<Fact> getFacts() {
        return facts;
    }

    public void setFacts(List<Fact> facts) {
        this.facts = facts;
    }

}
