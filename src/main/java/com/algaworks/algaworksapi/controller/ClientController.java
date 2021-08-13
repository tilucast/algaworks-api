package com.algaworks.algaworksapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaworksapi.domain.model.Client;
import com.algaworks.algaworksapi.domain.repository.ClientRepository;
import com.algaworks.algaworksapi.domain.service.ClientCatalogService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {
	
	//@Autowired
	private ClientRepository clientRepository;
	private ClientCatalogService clientCatalogService;

	@GetMapping("/")
	public String get() {
		return "Hey dude";
	}
	
	@GetMapping
	public List<Client> getClients() {
		
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getById(@PathVariable Long id) {
		
		return clientRepository.findById(id)
				//.map(client -> ResponseEntity.ok(client))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
//		Optional<Client> client = clientRepository.findById(id);
//		
//		if(client.isPresent()) {
//			return ResponseEntity.ok(client.get());
//		}
//		
//		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client) {
		//return clientRepository.save(client);
		return clientCatalogService.save(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @Valid @RequestBody Client client) {
		
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		//client =  clientRepository.save(client);
		client =  clientCatalogService.save(client);
		
		return ResponseEntity.ok(client);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		//clientRepository.deleteById(id);
		clientCatalogService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
