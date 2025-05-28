package com.dealership.project.application.useCases.car.getCar;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.domain.entities.offers.Car;
import com.dealership.project.infrastructure.repositories.JpaCarRepository;


@Service
public class GetCarUseCase {

    @Autowired
    private JpaCarRepository carRepository;

    public GetCarUseCaseResponse execute(GetCarUseCaseRequest request) {
        Optional<Car> findCar = carRepository.findById(request.id());
        return new GetCarUseCaseResponse(findCar);
    }
}
