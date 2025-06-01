package com.dealership.project.application.useCases.store.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.store.AbstractStoreUseCase;
import com.dealership.project.infrastructure.repositories.JpaCarRepository;
import com.dealership.project.presentation.exceptions.AssociationInUseException;
import com.dealership.project.presentation.exceptions.DatabaseException;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class DeleteStoreUseCase extends AbstractStoreUseCase {

	@Autowired
	private JpaCarRepository jpaOrderRepository;

    public void execute(DeleteStoreUseCaseRequest request) {
        Long id = request.id();
        try {
			boolean isStoreInUse = jpaOrderRepository.existsByEngineId(id);

			if (!isStoreInUse) {
				storeRepository.deleteById(id);
			} else {
				throw new AssociationInUseException("This model is already in use by fk");
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); //Passando exception da própria camada de serviço
		}
    }
}
