package com.dealership.project.api.dto;

import com.dealership.project.domain.entities.enums.EngineType;

import lombok.Data;

@Data
public class EngineDTO {
    private EngineType engineType;
    private Double horsepower;
    private boolean active;
}
