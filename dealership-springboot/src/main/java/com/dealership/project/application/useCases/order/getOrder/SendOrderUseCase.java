package com.dealership.project.application.useCases.order.getOrder;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.OrderUseCaseRequest;
import com.dealership.project.application.useCases.order.OrderUseCaseResponse;

import jakarta.transaction.Transactional;

@Service
public class SendOrderUseCase {

  // @Autowired
  // private JpaOrderRepository orderRepository;

  @Transactional
  public OrderUseCaseResponse execute(OrderUseCaseRequest data) {

    // Order order = new Order(data.car(), data.customization());

    // repository.save(order);

    return new OrderUseCaseResponse();
  }
}