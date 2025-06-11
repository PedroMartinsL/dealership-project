package com.dealership.project.application.useCases.order.update;

import java.util.List;

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
            Order order;

            if (securityService.isAdmin()) {
                order = orderRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(id));
            } else {
                String email = securityService.getUserEmail();
                List<Order> userOrders = orderRepository.findByUserEmail(email);

                order = userOrders.stream()
                        .filter(o -> o.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new ResourceNotFoundException(id));
            }

            updateData(order, orderDTO);
            order = orderRepository.save(order);

            return new UpdateOrderUseCaseResponse(order);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order order, OrderDTO orderDTO) {
        order.setStore(orderDTO.getStore());
    }
}
