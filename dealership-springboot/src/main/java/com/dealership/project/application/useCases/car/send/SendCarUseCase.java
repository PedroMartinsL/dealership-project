package com.dealership.project.application.useCases.car.send;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.car.AbstractCarUseCase;
import com.dealership.project.domain.entities.Car;

import jakarta.transaction.Transactional;

@Service
public class SendCarUseCase extends AbstractCarUseCase {

    @Transactional
    public SendCarUseCaseResponse execute(SendCarUseCaseRequest request) {
        try {
            Car car = new Car(request.carDTO());
            car = carRepository.save(car);
            return new SendCarUseCaseResponse(car);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao salvar pedido: " + e.getMessage(), e);
        }
    }
}
