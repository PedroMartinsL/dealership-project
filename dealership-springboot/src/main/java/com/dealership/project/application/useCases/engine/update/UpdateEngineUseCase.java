package com.dealership.project.application.useCases.engine.update;

import org.springframework.stereotype.Service;

import com.dealership.project.api.dto.EngineDTO;
import com.dealership.project.application.useCases.engine.AbstractEngineUseCase;
import com.dealership.project.domain.entities.Engine;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UpdateEngineUseCase extends AbstractEngineUseCase {

    @Transactional
    public UpdateEngineUseCaseResponse execute(UpdateEngineUseCaseRequest request) {
        Long id = request.id();
        EngineDTO engineDTO = request.EngineDTO();
        try {
            Engine engine = engineRepository.getReferenceById(id);
            updateData(engine, engineDTO);
            engine = engineRepository.save(engine);
            UpdateEngineUseCaseResponse response = new UpdateEngineUseCaseResponse(engine);
            return response;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Engine engine, EngineDTO engineDTO) {
        engine.setActive(engineDTO.isActive());
    }
}
