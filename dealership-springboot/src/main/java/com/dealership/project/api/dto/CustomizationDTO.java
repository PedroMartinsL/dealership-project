package com.dealership.project.api.dto;

import com.dealership.project.domain.entities.enums.CustomCoating;
import com.dealership.project.domain.entities.enums.CustomColor;
import com.dealership.project.domain.entities.enums.CustomWheel;

import lombok.Data;

@Data
public class CustomizationDTO {
    private CustomColor customColor;
    private CustomWheel customWheel;
    private CustomCoating customCoating;
}
