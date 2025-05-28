package com.dealership.project.application.useCases.getCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.infrastructure.repositories.CarRepository;

@Service
public class GetCarUseCase {

    @Autowired
    private CarRepository repository;

    public GetCarUseCaseResponse execute(GetCarUseCaseRequest request) {
        return new GetCarUseCaseResponse(repository.findById(request.id()));
    }
}
