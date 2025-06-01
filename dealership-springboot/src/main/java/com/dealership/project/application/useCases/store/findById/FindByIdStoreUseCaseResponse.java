package com.dealership.project.application.useCases.store.findById;

import com.dealership.project.domain.entities.Store;

public record FindByIdStoreUseCaseResponse (
  Store store
) {
}