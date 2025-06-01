package com.dealership.project.application.useCases.store.findAll;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.store.AbstractStoreUseCase;
import com.dealership.project.domain.entities.Store;

@Service
public class FindAllStoresUseCase extends AbstractStoreUseCase {

  public FindAllStoresUseCaseResponse execute() {
    List<Store> Stores = storeRepository.findAll();
    return new FindAllStoresUseCaseResponse(Stores);
  }
}