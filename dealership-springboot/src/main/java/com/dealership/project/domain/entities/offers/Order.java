package com.dealership.project.domain.entities.offers;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Car car;
    private Customization customization;

    public Order() {

    }

    public Order(Car car, Customization customization) {
        this.car = car;
        this.customization = customization;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customization getCustomization() {
        return customization;
    }

    public void setCustomization(Customization customization) {
        this.customization = customization;
    }

}