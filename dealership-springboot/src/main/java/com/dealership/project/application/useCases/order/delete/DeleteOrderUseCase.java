package com.dealership.project.application.useCases.order.delete;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.presentation.exceptions.DatabaseException;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class DeleteOrderUseCase extends AbstractOrderUseCase {

    public void execute(DeleteOrderUseCaseRequest request) {
        Long id = request.id();

    try {
        if (securityService.isAdmin()) {
            orderRepository.deleteById(id);
        } else {
            String email = securityService.getUserEmail();

            List<Order> userOrders = orderRepository.findByUserEmail(email);
            boolean isOwner = userOrders.stream().anyMatch(o -> o.getId().equals(id));

            if (!isOwner) {
                throw new ResourceNotFoundException(id); // impede acesso não autorizado
            }

            orderRepository.deleteById(id);
        }

    } catch (EmptyResultDataAccessException e) {
        throw new ResourceNotFoundException(id);

    } catch (DataIntegrityViolationException e) {
        throw new DatabaseException(e.getMessage());
    }
    }
}
