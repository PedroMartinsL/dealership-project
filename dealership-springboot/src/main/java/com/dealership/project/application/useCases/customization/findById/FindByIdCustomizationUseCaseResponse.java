package com.dealership.project.application.useCases.customization.findById;

import com.dealership.project.domain.entities.Customization;

public record FindByIdCustomizationUseCaseResponse (
  Customization customization
) {
}