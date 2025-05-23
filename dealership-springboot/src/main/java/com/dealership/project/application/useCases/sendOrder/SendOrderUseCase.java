package com.dealership.project.application.useCases.sendOrder;

public class SendOrderUseCase {
  public SendOrderUseCaseResponse execute(SendOrderUseCaseRequest data) {
    return new SendOrderUseCaseResponse(data.name(),
            data.price(),
            data.description(),
            data.category());
  }
}