package com.dealership.project.application.useCases.engine.send;

import com.dealership.project.domain.entities.Engine;

public record SendEngineUseCaseResponse (
  Engine engine
) {
}