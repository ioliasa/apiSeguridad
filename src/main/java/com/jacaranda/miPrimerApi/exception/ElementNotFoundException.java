package com.jacaranda.miPrimerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementNotFoundException(Long id) {
		super("No se puede encontrar el elemnto con id=" + id);
	}
	
}
