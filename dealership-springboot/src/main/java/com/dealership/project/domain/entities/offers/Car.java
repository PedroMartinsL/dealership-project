package com.dealership.project.domain.entities.offers;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String model;
    @ManyToOne()
    private Engine engine;
    private Double weight;
    private Integer autonomyKm;

    public Car() {

    }

    public Car(String model, Engine engine, Double weight, Integer autonomyKm) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.autonomyKm = autonomyKm;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAutonomyKm() {
        return autonomyKm;
    }

    public void setAutonomyKm(Integer autonomyKm) {
        this.autonomyKm = autonomyKm;
    }

}
