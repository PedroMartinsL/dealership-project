package com.dealership.project.domain.entities.offers;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Engine implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "car_id")  // ou o nome da chave estrangeira
    private Car car;
}