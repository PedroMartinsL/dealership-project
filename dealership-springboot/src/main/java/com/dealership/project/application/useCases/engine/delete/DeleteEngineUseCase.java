package com.dealership.project.application.useCases.engine.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.engine.AbstractEngineUseCase;
import com.dealership.project.infrastructure.repositories.JpaCarRepository;
import com.dealership.project.presentation.exceptions.AssociationInUseException;
import com.dealership.project.presentation.exceptions.DatabaseException;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class DeleteEngineUseCase extends AbstractEngineUseCase {

	@Autowired
	private JpaCarRepository jpaCarRepository;

    public void execute(DeleteEngineUseCaseRequest request) {
        Long id = request.id();
        try {
			boolean isEngineInUse = jpaCarRepository.existsByEngineId(id);

			if (!isEngineInUse) {
				engineRepository.deleteById(id);
			} else {
				throw new AssociationInUseException(String.format("This model %d is already in use, try to deactivate it instead", id));
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); //Passando exception da própria camada de serviço
		}
    }
}
