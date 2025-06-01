package com.dealership.project.application.useCases.car.findAll;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.car.AbstractCarUseCase;
import com.dealership.project.domain.entities.Car;

@Service
public class FindAllCarsUseCase extends AbstractCarUseCase {

    public FindAllCarsUseCaseResponse execute() {
        List<Car> listCars = carRepository.findAll();
        return new FindAllCarsUseCaseResponse(listCars);
    }
}
