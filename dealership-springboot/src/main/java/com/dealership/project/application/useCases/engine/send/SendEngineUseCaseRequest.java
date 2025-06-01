package com.dealership.project.application.useCases.engine.send;

import com.dealership.project.api.dto.EngineDTO;

public record SendEngineUseCaseRequest(
  EngineDTO engineDTO
) {
}