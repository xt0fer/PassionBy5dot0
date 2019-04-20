package com.caraeppes.EduWaiterAppServer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
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
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;
    @OneToMany(mappedBy = "restaurant")
    private List<AdminAccount> admin;
    @OneToMany(mappedBy = "restaurant")
    private List<EmployeeAccount> employees;
    @OneToMany(mappedBy = "restaurant")
    private List<Fact> facts;



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

    @Override
    public String toString() {
        return id.toString();
    }
}
