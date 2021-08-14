package com.algaworks.algaworksapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algaworksapi.domain.model.Client;
import com.algaworks.algaworksapi.domain.model.Delivery;
import com.algaworks.algaworksapi.domain.model.StatusEntrega;
import com.algaworks.algaworksapi.domain.repository.DeliverRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateDeliveryService {

	private DeliverRepository deliverRepository;
	private ClientCatalogService clientCatalogService;
	
	@Transactional
	public Delivery request(Delivery delivery) {
		Client client = clientCatalogService.get(delivery.getClient().getId());
		
		delivery.setClient(client);
		delivery.setStatusEntrega(StatusEntrega.PENDING);
		var now = LocalDateTime.now();
		delivery.setRequestDate(LocalDateTime.now());
		var deliveredDate = now.plusDays(7);
		delivery.setDeliveredDate(deliveredDate);
		
		return deliverRepository.save(delivery);
	}
}
