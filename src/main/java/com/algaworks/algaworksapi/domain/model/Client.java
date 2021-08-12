package com.algaworks.algaworksapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Client {

	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String phone;
	@NonNull
	private String email;
	
}
