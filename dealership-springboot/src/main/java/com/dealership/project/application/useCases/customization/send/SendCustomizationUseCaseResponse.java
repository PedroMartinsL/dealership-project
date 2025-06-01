package com.dealership.project.application.useCases.customization.send;

import com.dealership.project.domain.entities.Customization;

public record SendCustomizationUseCaseResponse (
  Customization customization
) {
}