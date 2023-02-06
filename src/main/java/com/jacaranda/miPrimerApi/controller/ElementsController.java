package com.jacaranda.miPrimerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimerApi.exception.ApiError;
import com.jacaranda.miPrimerApi.exception.ElementNotFoundException;
import com.jacaranda.miPrimerApi.model.Elements;
import com.jacaranda.miPrimerApi.service.ElementsService;

@RestController
public class ElementsController {
	
	@Autowired
	private ElementsService servicio;
	
	@GetMapping("/element")
	public ResponseEntity<?> findAll(){
		List<Elements> result =  servicio.findAll();
		
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
		
	}
	
	
	@GetMapping("/element/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Elements result = servicio.findById(id);
		if (result == null ) {
			//return ResponseEntity.notFound().build();
			throw new ElementNotFoundException(id);
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	
	
	
	@PostMapping("/element/")
	public ResponseEntity<?> add(@RequestBody Elements elemento) {
		Elements resultado = servicio.save(elemento);
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
		
	}
	
	
	@PutMapping("/element/{id}")
	public ResponseEntity<?> edit(@RequestBody Elements elemento, @PathVariable Long id) {
		if (servicio.findById(id)!= null) {
			elemento.setId(id);
			Elements result = servicio.save(elemento);
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
			
	}
	
	@DeleteMapping("/element/{id}")
	public Elements del(@PathVariable Long id) {
		if (servicio.findById(id)!= null) {
			Elements elemento = servicio.findById(id);
			servicio.del(elemento);
			return elemento;
		}else {
			return null;
		}
	}

}
