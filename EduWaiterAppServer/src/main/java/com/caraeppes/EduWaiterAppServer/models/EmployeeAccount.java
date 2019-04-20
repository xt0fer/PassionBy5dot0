package com.caraeppes.EduWaiterAppServer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "employee_accounts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeAccount extends Account{

    @Column(name = "admins")
    @ManyToMany
    private List<AdminAccount> admins;

    public List<AdminAccount> getAdmins() {
        return admins;
    }

    public void setAdmins(List<AdminAccount> admins) {
        this.admins = admins;
    }
}
