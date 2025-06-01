package com.dealership.project.api.dto;

import com.dealership.project.domain.entities.Engine;

import lombok.Data;

@Data
public class CarDTO {
    private String model;
    private Engine engine;
    private Double weight;
    private Integer autonomyKm;
    private boolean active = true;
}
