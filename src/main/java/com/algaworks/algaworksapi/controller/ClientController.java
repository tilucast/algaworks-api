package com.algaworks.algaworksapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaworksapi.domain.model.Client;

@RestController
public class ClientController {

	@GetMapping("/")
	public String get() {
		System.out.println("I am working dude");
		return "Hey dude";
	}
	
	@GetMapping("/clients")
	public List<Client> getClients() {
		
		var client = new Client("A", "B", "benis@benis.com");
		var client2 = new Client("C", "D", "quenis@penico.com");
		
		return Arrays.asList(client, client2);
	}
	
}
