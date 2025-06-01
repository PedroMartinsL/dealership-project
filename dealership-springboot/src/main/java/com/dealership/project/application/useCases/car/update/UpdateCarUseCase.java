package com.dealership.project.application.useCases.car.update;

import org.springframework.stereotype.Service;

import com.dealership.project.api.dto.CarDTO;
import com.dealership.project.application.useCases.car.AbstractCarUseCase;
import com.dealership.project.domain.entities.Car;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UpdateCarUseCase extends AbstractCarUseCase {

    @Transactional
    public UpdateCarUseCaseResponse execute(UpdateCarUseCaseRequest request) {
        Long id = request.id();
        CarDTO carDTO = request.carDTO();
        try {
            Car car = carRepository.getReferenceById(id);
            updateData(car, carDTO);
            car = carRepository.save(car);
            UpdateCarUseCaseResponse response = new UpdateCarUseCaseResponse(car);
            return response;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Car car, CarDTO carDTO) {
        car.setEngine(carDTO.getEngine());
        car.setAutonomyKm(carDTO.getAutonomyKm());
        car.setActive(carDTO.isActive());
        car.setModel(carDTO.getModel());
        car.setWeight(carDTO.getWeight());
    }
}
