package com.dealership.project.application.useCases.customization.findAll;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.customization.AbstractCustomizationUseCase;
import com.dealership.project.domain.entities.Customization;

@Service
public class FindAllCustomizationsUseCase extends AbstractCustomizationUseCase {

  public FindAllCustomizationsUseCaseResponse execute() {
    List<Customization> customizations;

    if (securityService.isAdmin()) {
        customizations = customizationRepository.findAll();
    } else {
        String userEmail = securityService.getUserEmail();
        customizations = customizationRepository.findByUserEmail(userEmail);
    }

    return new FindAllCustomizationsUseCaseResponse(customizations);
  }
}