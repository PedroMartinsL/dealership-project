package com.dealership.project.application.useCases.order.update;

import org.springframework.stereotype.Service;

import com.dealership.project.api.dto.OrderDTO;
import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UpdateOrderUseCase extends AbstractOrderUseCase {

    @Transactional
    public UpdateOrderUseCaseResponse execute(UpdateOrderUseCaseRequest request) {
        Long id = request.id();
        OrderDTO orderDTO = request.orderDTO();
        try {
            Order order = orderRepository.getReferenceById(id);
            updateData(order, orderDTO);
            order = orderRepository.save(order);
            UpdateOrderUseCaseResponse response = new UpdateOrderUseCaseResponse(order);
            return response;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order order, OrderDTO orderDTO) {
        order.setStore(orderDTO.getStore());
    }
}
