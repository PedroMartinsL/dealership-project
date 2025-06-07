package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.EngineDTO;
import com.dealership.project.application.useCases.engine.delete.DeleteEngineUseCase;
import com.dealership.project.application.useCases.engine.delete.DeleteEngineUseCaseRequest;
import com.dealership.project.application.useCases.engine.findAll.FindAllEnginesUseCase;
import com.dealership.project.application.useCases.engine.findAll.FindAllEnginesUseCaseResponse;
import com.dealership.project.application.useCases.engine.findById.FindByIdEngineUseCase;
import com.dealership.project.application.useCases.engine.findById.FindByIdEngineUseCaseRequest;
import com.dealership.project.application.useCases.engine.findById.FindByIdEngineUseCaseResponse;
import com.dealership.project.application.useCases.engine.send.SendEngineUseCase;
import com.dealership.project.application.useCases.engine.send.SendEngineUseCaseRequest;
import com.dealership.project.application.useCases.engine.send.SendEngineUseCaseResponse;
import com.dealership.project.application.useCases.engine.update.UpdateEngineUseCase;
import com.dealership.project.application.useCases.engine.update.UpdateEngineUseCaseRequest;
import com.dealership.project.application.useCases.engine.update.UpdateEngineUseCaseResponse;
import com.dealership.project.domain.entities.Engine;

@RestController
@RequestMapping(value = "/engines")
public class EngineController {

    @Autowired
    private SendEngineUseCase sendEngineUseCase;

    @Autowired
    private FindByIdEngineUseCase findByIdEngineUseCase;

    @Autowired
    private FindAllEnginesUseCase findAllEnginesUseCase;

    @Autowired
    private UpdateEngineUseCase updateEngineUseCase;

    @Autowired
    private DeleteEngineUseCase deleteEngineUseCase;

    @GetMapping
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    public ResponseEntity<List<Engine>> findAll() {
		FindAllEnginesUseCaseResponse response = findAllEnginesUseCase.execute();
        List<Engine> EnginesList = response.engines();
		return ResponseEntity.ok().body(EnginesList);
	}

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    public ResponseEntity<Engine> findById(@PathVariable Long id) {
		FindByIdEngineUseCaseRequest EngineRequest = new FindByIdEngineUseCaseRequest(id);
        FindByIdEngineUseCaseResponse EngineReponse = findByIdEngineUseCase.execute(EngineRequest);
        Engine Engine = EngineReponse.engine();
		return ResponseEntity.ok().body(Engine);
	}

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Engine> insert(
        @RequestBody EngineDTO engineDTO
    ) {
        SendEngineUseCaseRequest EngineRequest = new SendEngineUseCaseRequest(engineDTO);
        SendEngineUseCaseResponse EngineResponse = sendEngineUseCase.execute(EngineRequest);
        Engine engine = EngineResponse.engine();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(engine.getId()).toUri();
		return ResponseEntity.created(uri).body(engine);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
        DeleteEngineUseCaseRequest request = new DeleteEngineUseCaseRequest(id);
		deleteEngineUseCase.execute(request);
		return ResponseEntity.noContent().build();
	}

    // Only for Deactive
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Engine> update(@PathVariable Long id, @RequestBody EngineDTO EngineDTO) {
        UpdateEngineUseCaseRequest request = new UpdateEngineUseCaseRequest(id, EngineDTO);
		UpdateEngineUseCaseResponse response = updateEngineUseCase.execute(request);
        Engine Engine = response.Engine();
		return ResponseEntity.ok().body(Engine);
	}
}
