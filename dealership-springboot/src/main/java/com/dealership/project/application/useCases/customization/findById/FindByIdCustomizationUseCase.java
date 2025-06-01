package com.dealership.project.application.useCases.customization.findById;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.customization.AbstractCustomizationUseCase;
import com.dealership.project.domain.entities.Customization;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class FindByIdCustomizationUseCase extends AbstractCustomizationUseCase {

  public FindByIdCustomizationUseCaseResponse execute(FindByIdCustomizationUseCaseRequest request) {
    Long id = request.customizationId();
    Customization Customization = customizationRepository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException(id));
    return new FindByIdCustomizationUseCaseResponse(Customization);
  }
}