package com.dealership.project.application.useCases.car.update;

import com.dealership.project.api.dto.CarDTO;

public record UpdateCarUseCaseRequest(Long id, CarDTO carDTO) {
}
