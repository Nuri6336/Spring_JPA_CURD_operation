package com.nuri.bikesolution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parts")
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String partsName;
    private Integer partsPrice;
    private Integer partsQuantity;

//    @ManyToOne
//    @JoinColumn(name = "bike_name")
//    private Bike bike;
//
//    public Bike getBike() {
//        return bike;
//    }
//
//    public void setBike(Bike bike) {
//        this.bike = bike;
//    }

    public Parts() {
    }

    public Parts(Integer id, String partsName, Integer partsPrice, Integer partsQuantity) {
        this.id = id;
        this.partsName = partsName;
        this.partsPrice = partsPrice;
        this.partsQuantity = partsQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public Integer getPartsPrice() {
        return partsPrice;
    }

    public void setPartsPrice(Integer partsPrice) {
        this.partsPrice = partsPrice;
    }

    public Integer getPartsQuantity() {
        return partsQuantity;
    }

    public void setPartsQuantity(Integer partsQuantity) {
        this.partsQuantity = partsQuantity;
    }
}
