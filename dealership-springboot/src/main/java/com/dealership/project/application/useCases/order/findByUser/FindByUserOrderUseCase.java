package com.dealership.project.application.useCases.order.findByUser;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class FindByUserOrderUseCase extends AbstractOrderUseCase {

    @Transactional
    public FindByUserOrderUseCaseResponse execute(FindByUserOrderUseCaseRequest request) {
        String userId = request.userId();
        List<Order> orderList = orderRepository.findByUserId(userId);
        if (orderList.isEmpty()) {
            throw new ResourceNotFoundException(userId);
        }
        return new FindByUserOrderUseCaseResponse(orderList);
    }
}
