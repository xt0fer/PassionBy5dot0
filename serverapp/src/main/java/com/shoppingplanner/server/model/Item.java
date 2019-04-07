package com.shoppingplanner.server.model;

import com.shoppingplanner.server.model.modelenum.ItemCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private ItemCategory category;
}
