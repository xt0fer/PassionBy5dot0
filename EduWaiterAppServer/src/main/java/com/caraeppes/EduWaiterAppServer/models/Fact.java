package com.caraeppes.EduWaiterAppServer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "facts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fact_id")
    private Long id;
    @Column(name = "fact")
    private String fact;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
    @Column(name = "entity_id")
    private Long entityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}
