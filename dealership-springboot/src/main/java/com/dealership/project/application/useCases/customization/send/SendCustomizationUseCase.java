package com.dealership.project.application.useCases.customization.send;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.customization.AbstractCustomizationUseCase;
import com.dealership.project.domain.entities.Customization;

import jakarta.transaction.Transactional;

@Service
public class SendCustomizationUseCase extends AbstractCustomizationUseCase {

    @Transactional
    public SendCustomizationUseCaseResponse execute(SendCustomizationUseCaseRequest request) {
        try {
            Customization customization = new Customization(request.customizationDTO());
            customization = customizationRepository.save(customization);
            return new SendCustomizationUseCaseResponse(customization);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao salvar pedido: " + e.getMessage(), e);
        }
    }
}
