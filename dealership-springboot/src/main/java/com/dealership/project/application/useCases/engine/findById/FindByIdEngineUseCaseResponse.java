package com.dealership.project.application.useCases.engine.findById;

import com.dealership.project.domain.entities.Engine;

public record FindByIdEngineUseCaseResponse (
  Engine engine
) {
}