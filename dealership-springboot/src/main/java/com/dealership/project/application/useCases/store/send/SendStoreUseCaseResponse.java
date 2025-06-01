package com.dealership.project.application.useCases.store.send;

import com.dealership.project.domain.entities.Store;

public record SendStoreUseCaseResponse (
  Store store
) {
}