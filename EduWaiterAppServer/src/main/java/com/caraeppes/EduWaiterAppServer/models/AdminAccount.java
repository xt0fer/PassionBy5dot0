package com.caraeppes.EduWaiterAppServer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "admin_accounts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdminAccount extends Account {

    @ManyToMany
    @Column(name = "employees")
    private List<EmployeeAccount> employees;

    public List<EmployeeAccount> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeAccount> employees) {
        this.employees = employees;
    }
}
