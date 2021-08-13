package com.algaworks.algaworksapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorException {
	
	
	private Integer status;
	private LocalDateTime dateHour;
	private String title;
	private List<Field> fields;
	
	
	@Getter
	@Setter
	@AllArgsConstructor
	public static class Field{
		private String name;
		private String message;
	}
	
}
