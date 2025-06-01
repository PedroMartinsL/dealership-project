package com.dealership.project.application.useCases.customization.send;

import com.dealership.project.api.dto.CustomizationDTO;

public record SendCustomizationUseCaseRequest(
  CustomizationDTO customizationDTO
) {
}