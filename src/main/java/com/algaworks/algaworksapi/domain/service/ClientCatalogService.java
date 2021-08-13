package com.algaworks.algaworksapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algaworksapi.domain.model.Client;
import com.algaworks.algaworksapi.domain.repository.ClientRepository;
import com.algaworks.algaworksapi.exceptionhandler.ValidationRulesException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientCatalogService {

	private ClientRepository clientRepository;
	
	@Transactional
	public Client save(Client client) {
		boolean emailRegistered = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(cclient -> {
					System.out.println(cclient);
					System.out.println(client);
					return !cclient.equals(client);
				});
		
		if(emailRegistered) {
			throw new ValidationRulesException("Email already registered.");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}
