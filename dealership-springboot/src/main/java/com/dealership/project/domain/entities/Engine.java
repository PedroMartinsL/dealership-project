package com.dealership.project.domain.entities;

import java.io.Serializable;

import com.dealership.project.api.dto.EngineDTO;
import com.dealership.project.domain.entities.enums.EngineType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Engine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer engineType;
    private Double horsepower;

    @Column(name = "active")
    private boolean active = true;

    public Engine() {

    }

    public Engine(Long id, Integer engineType, Double horsepower) {
        this.id = id;
        this.engineType = engineType;
        this.horsepower = horsepower;
    }

    public Engine(EngineDTO engineDTO) {
        this.horsepower = engineDTO.getHorsepower();
        this.engineType = engineDTO.getEngineType().getCode();
        this.active = engineDTO.isActive();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public EngineType getEngineType() {
        if (engineType == null) {
            return null;
        }
        return EngineType.valueOf(engineType);
    }

    public void setEngineType(EngineType engineType) {
        if (engineType != null) {
            this.engineType = engineType.getCode();
        }
    }

    public Double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Double horsepower) {
        this.horsepower = horsepower;
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Engine other = (Engine) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
