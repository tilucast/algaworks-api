package com.algaworks.algaworksapi.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaworksapi.domain.model.Client;

@RestController
public class ClientController {
	
	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/")
	public String get() {
		System.out.println("I am working dude");
		return "Hey dude";
	}
	
	@GetMapping("/clients")
	public List<Client> getClients() {
		
		return manager.createQuery("from Client", Client.class)
				.getResultList();
	}
	
}
