package com.dealership.project.application.useCases.order.findByStore;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class FindByStoreOrderUseCase extends AbstractOrderUseCase {

    public FindByStoreOrderUseCaseResponse execute(FindByStoreOrderUseCaseRequest request) {
        Long storeId = request.storeId();
        List<Order> orderList = orderRepository.findByStoreId(storeId);
        if (orderList.isEmpty()) {
            throw new ResourceNotFoundException(storeId);
        }
        return new FindByStoreOrderUseCaseResponse(orderList);
    }
}
