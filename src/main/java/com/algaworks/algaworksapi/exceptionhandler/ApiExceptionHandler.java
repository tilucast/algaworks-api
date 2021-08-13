package com.algaworks.algaworksapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	private MessageSource msgSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var fields = new ArrayList<ErrorException.Field>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String name =  ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			//String message = msgSource.getMessage(error, LocaleContextHolder.getLocale());
			
			fields.add(new ErrorException.Field(name, message));
		});
		
		var errorException = new ErrorException(status.value(), LocalDateTime.now(), "One or more fields are invalid.", fields);
		
		return handleExceptionInternal(ex, errorException, headers, status, request);
	}
	
	@ExceptionHandler(ValidationRulesException.class)
	public ResponseEntity<Object> handleValidationRules(ValidationRulesException exception, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		return handleExceptionInternal(exception, new ErrorException(status.value(), LocalDateTime.now(), exception.getMessage()), new HttpHeaders(), status, request);
	}
	
}
