package com.dealership.project.application.useCases.engine.send;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.engine.AbstractEngineUseCase;
import com.dealership.project.domain.entities.Engine;

import jakarta.transaction.Transactional;

@Service
public class SendEngineUseCase extends AbstractEngineUseCase {

    @Transactional
    public SendEngineUseCaseResponse execute(SendEngineUseCaseRequest request) {
        try {
            Engine engine = new Engine(request.engineDTO());
            engine = engineRepository.save(engine);
            return new SendEngineUseCaseResponse(engine);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao salvar pedido: " + e.getMessage(), e);
        }
    }
}
