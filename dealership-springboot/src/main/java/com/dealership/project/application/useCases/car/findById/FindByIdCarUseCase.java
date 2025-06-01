package com.dealership.project.application.useCases.car.findById;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.car.AbstractCarUseCase;
import com.dealership.project.domain.entities.Car;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;


@Service
public class FindByIdCarUseCase extends AbstractCarUseCase {

    public FindByIdCarUseCaseResponse execute(FindByIdCarUseCaseRequest request) {
        Long id = request.id();
        Car findCar = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new FindByIdCarUseCaseResponse(findCar);
    }
}
