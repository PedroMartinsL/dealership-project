package com.dealership.project.application.useCases.sendOrder;

public record SendOrderUseCaseRequest(
  String name,
  Double price,
  String description,
  String category
) {
}