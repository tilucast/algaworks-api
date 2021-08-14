package com.algaworks.algaworksapi.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Client client;
	
	@Embedded
	private Receiver receiver;
	
	private BigDecimal fee;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	@JsonProperty(access = Access.READ_ONLY)
	private StatusEntrega statusEntrega;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime requestDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime deliveredDate;
	
}
