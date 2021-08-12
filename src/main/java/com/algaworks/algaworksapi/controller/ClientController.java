package com.algaworks.algaworksapi.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaworksapi.domain.model.Client;
import com.algaworks.algaworksapi.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {
	
	//@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/")
	public String get() {
		return "Hey dude";
	}
	
	@GetMapping("/clients")
	public List<Client> getClients() {
		
		return clientRepository.findAll();
	}
	
}
