package com.dealership.project.application.useCases.engine.update;

import com.dealership.project.api.dto.EngineDTO;

public record UpdateEngineUseCaseRequest(Long id, EngineDTO EngineDTO) {
}
