package com.dealership.project.application.useCases.engine.findAll;

import java.util.List;

import com.dealership.project.domain.entities.Engine;

public record FindAllEnginesUseCaseResponse (
  List<Engine> engines
) {
}