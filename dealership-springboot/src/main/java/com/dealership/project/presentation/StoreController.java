package com.dealership.project.presentation;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.StoreDTO;
import com.dealership.project.application.useCases.store.delete.DeleteStoreUseCase;
import com.dealership.project.application.useCases.store.delete.DeleteStoreUseCaseRequest;
import com.dealership.project.application.useCases.store.findAll.FindAllStoresUseCase;
import com.dealership.project.application.useCases.store.findAll.FindAllStoresUseCaseResponse;
import com.dealership.project.application.useCases.store.findById.FindByIdStoreUseCase;
import com.dealership.project.application.useCases.store.findById.FindByIdStoreUseCaseRequest;
import com.dealership.project.application.useCases.store.findById.FindByIdStoreUseCaseResponse;
import com.dealership.project.application.useCases.store.send.SendStoreUseCase;
import com.dealership.project.application.useCases.store.send.SendStoreUseCaseRequest;
import com.dealership.project.application.useCases.store.send.SendStoreUseCaseResponse;
import com.dealership.project.application.useCases.store.update.UpdateStoreUseCase;
import com.dealership.project.application.useCases.store.update.UpdateStoreUseCaseRequest;
import com.dealership.project.application.useCases.store.update.UpdateStoreUseCaseResponse;
import com.dealership.project.domain.entities.Store;

@Controller
@RequestMapping(value = "/stores")
public class StoreController {

    @Autowired
    private SendStoreUseCase sendStoreUseCase;

    @Autowired
    private FindByIdStoreUseCase findByIdStoreUseCase;

    @Autowired
    private FindAllStoresUseCase findAllStoresUseCase;

    @Autowired
    private DeleteStoreUseCase deleteStoreUseCase;

    @Autowired
    private UpdateStoreUseCase updateStoreUseCase;
    
    @GetMapping
	public ResponseEntity<FindAllStoresUseCaseResponse> findAll() {
		FindAllStoresUseCaseResponse response = findAllStoresUseCase.execute();
		return ResponseEntity.ok().body(response);
	}

    @GetMapping(value = "/{id}")
	public ResponseEntity<FindByIdStoreUseCaseResponse> findById(@PathVariable Long id) {
		FindByIdStoreUseCaseRequest request = new FindByIdStoreUseCaseRequest(id);
		FindByIdStoreUseCaseResponse response = findByIdStoreUseCase.execute(request);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping
    public ResponseEntity<Store> insert(
        @RequestBody StoreDTO storeDTO
    ) {
        SendStoreUseCaseRequest storeRequest = new SendStoreUseCaseRequest(storeDTO);
        SendStoreUseCaseResponse StoreResponse = sendStoreUseCase.execute(storeRequest);
        Store Store = StoreResponse.store();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Store.getId()).toUri();
		return ResponseEntity.created(uri).body(Store);
    }

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
        DeleteStoreUseCaseRequest request = new DeleteStoreUseCaseRequest(id);
		deleteStoreUseCase.execute(request);
		return ResponseEntity.noContent().build();
	}

    @PutMapping("/{id}")
    public ResponseEntity<Store> update(@PathVariable Long id, @RequestBody StoreDTO StoreDTO) {
        UpdateStoreUseCaseRequest request = new UpdateStoreUseCaseRequest(id, StoreDTO);
		UpdateStoreUseCaseResponse response = updateStoreUseCase.execute(request);
        Store Store = response.store();
		return ResponseEntity.ok().body(Store);
	}
}
