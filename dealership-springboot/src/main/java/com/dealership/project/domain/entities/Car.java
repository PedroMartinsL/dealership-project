package com.dealership.project.domain.entities;

import java.io.Serializable;

import com.dealership.project.api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;
    private String model;
    private Double weight;
    private Integer autonomyKm;

    @Column(name = "active")
    private boolean active = true;

    public Car() {

    }

    public Car(Long id, String model, Engine engine, Double weight, Integer autonomyKm) {
        this.id = id;
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.autonomyKm = autonomyKm;
    }

    public Car(CarDTO carDTO) {
        this.engine = carDTO.getEngine();
        this.autonomyKm = carDTO.getAutonomyKm();
        this.active = carDTO.isActive();
        this.model = carDTO.getModel();
        this.weight = carDTO.getWeight();
    }

    public Long getId() {
        return id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
