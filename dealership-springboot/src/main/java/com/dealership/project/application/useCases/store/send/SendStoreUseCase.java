package com.dealership.project.application.useCases.store.send;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.store.AbstractStoreUseCase;
import com.dealership.project.domain.entities.Store;

import jakarta.transaction.Transactional;

@Service
public class SendStoreUseCase extends AbstractStoreUseCase {

    @Transactional
    public SendStoreUseCaseResponse execute(SendStoreUseCaseRequest request) {
        try {
            Store store = new Store(request.storeDTO());
            store = storeRepository.save(store);
            return new SendStoreUseCaseResponse(store);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao salvar pedido: " + e.getMessage(), e);
        }
    }
}
