package com.dealership.project.application.useCases.customization.findAll;

import java.util.List;

import com.dealership.project.domain.entities.Customization;

public record FindAllCustomizationsUseCaseResponse (
  List<Customization> customizations
) {
}