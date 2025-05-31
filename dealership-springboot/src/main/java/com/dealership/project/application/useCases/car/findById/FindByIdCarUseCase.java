package com.dealership.project.application.useCases.car.findById;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.domain.entities.Car;
import com.dealership.project.infrastructure.repositories.JpaCarRepository;


@Service
public class FindByIdCarUseCase {

    @Autowired
    private JpaCarRepository carRepository;

    public FindByIdCarUseCaseResponse execute(FindByIdCarUseCaseRequest request) {
        Optional<Car> findCar = carRepository.findById(request.id());
        return new FindByIdCarUseCaseResponse(findCar);
    }
}
