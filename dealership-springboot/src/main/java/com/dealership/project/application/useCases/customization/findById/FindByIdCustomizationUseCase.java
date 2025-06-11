package com.dealership.project.application.useCases.customization.findById;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.customization.AbstractCustomizationUseCase;
import com.dealership.project.domain.entities.Customization;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class FindByIdCustomizationUseCase extends AbstractCustomizationUseCase {

  public FindByIdCustomizationUseCaseResponse execute(FindByIdCustomizationUseCaseRequest request) {
    Long id = request.customizationId();

    Customization customization;

    if (securityService.isAdmin()) {
        customization = customizationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
    } else {
        String email = securityService.getUserEmail(); 
        List<Customization> userCustomizations = customizationRepository.findByUserEmail(email);

        customization = userCustomizations.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    return new FindByIdCustomizationUseCaseResponse(customization);
  }
}