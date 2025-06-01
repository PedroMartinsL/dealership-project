package com.dealership.project.application.useCases.engine.findAll;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.engine.AbstractEngineUseCase;
import com.dealership.project.domain.entities.Engine;

@Service
public class FindAllEnginesUseCase extends AbstractEngineUseCase {

  public FindAllEnginesUseCaseResponse execute() {
    List<Engine> engines = engineRepository.findAll();
    return new FindAllEnginesUseCaseResponse(engines);
  }
}