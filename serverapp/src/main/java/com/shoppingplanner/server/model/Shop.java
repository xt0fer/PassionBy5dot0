package com.shoppingplanner.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Shop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    Set<ShopDetail> shopDetails;

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

    public Set<ShopDetail> getShopDetails() {
        return shopDetails;
    }

    public void setShopDetails(Set<ShopDetail> shopDetails) {
        this.shopDetails = shopDetails;
    }


}
