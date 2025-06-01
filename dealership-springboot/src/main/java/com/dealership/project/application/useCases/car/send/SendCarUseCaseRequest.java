package com.dealership.project.application.useCases.car.send;

import com.dealership.project.api.dto.CarDTO;

public record SendCarUseCaseRequest(
  CarDTO carDTO
) {
}