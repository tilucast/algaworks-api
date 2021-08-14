package com.algaworks.algaworksapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaworksapi.domain.model.Delivery;
import com.algaworks.algaworksapi.domain.service.CreateDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	private CreateDeliveryService createDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery requestDelivery(@RequestBody Delivery delivery) {
		return createDeliveryService.request(delivery);
	}
	
}
