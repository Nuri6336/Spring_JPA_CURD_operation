package com.nuri.bikesolution.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bike")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bikeName;
    private Integer bikePrice;
    private Integer bikeQuantity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bike_id", referencedColumnName = "id")
    private List<Parts> parts;

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public Bike() {
    }

    public Bike(Integer id, String bikeName, Integer bikePrice, Integer bikeQuantity) {
        this.id = id;
        this.bikeName = bikeName;
        this.bikePrice = bikePrice;
        this.bikeQuantity = bikeQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public Integer getBikePrice() {
        return bikePrice;
    }

    public void setBikePrice(Integer bikePrice) {
        this.bikePrice = bikePrice;
    }

    public Integer getBikeQuantity() {
        return bikeQuantity;
    }

    public void setBikeQuantity(Integer bikeQuantity) {
        this.bikeQuantity = bikeQuantity;
    }
}
