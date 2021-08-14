package com.algaworks.algaworksapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algaworksapi.domain.model.Delivery;

@Repository
public interface DeliverRepository extends JpaRepository<Delivery, Long>{

}
