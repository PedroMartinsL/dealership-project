package com.dealership.project.application.useCases.engine.findById;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.engine.AbstractEngineUseCase;
import com.dealership.project.domain.entities.Engine;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class FindByIdEngineUseCase extends AbstractEngineUseCase {

  public FindByIdEngineUseCaseResponse execute(FindByIdEngineUseCaseRequest request) {
    Long id = request.engineId();
    Engine engine = engineRepository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException(id));
    return new FindByIdEngineUseCaseResponse(engine);
  }
}