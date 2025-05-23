package com.dealership.project.application.useCases.sendOrder;

public record SendOrderUseCaseResponse (
  String name,
  Double price,
  String description,
  String category
) {
}