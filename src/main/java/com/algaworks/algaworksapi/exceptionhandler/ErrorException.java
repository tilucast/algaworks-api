package com.algaworks.algaworksapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorException {
	
	@NonNull
	private Integer status;
	@NonNull
	private LocalDateTime dateHour;
	@NonNull
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
