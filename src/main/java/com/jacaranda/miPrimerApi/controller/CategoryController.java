package com.jacaranda.miPrimerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimerApi.exception.ElementNotFoundException;
import com.jacaranda.miPrimerApi.model.Category;
import com.jacaranda.miPrimerApi.model.Elements;
import com.jacaranda.miPrimerApi.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService servicio;
	
	@GetMapping("/category")
	public ResponseEntity<?> findAll(){
		List<Category> result =  servicio.findAll();
		
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
		
	}
	
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) throws Exception {
		Category result = servicio.findById(id);
		if (result == null ) {
			//return ResponseEntity.notFound().build();
			throw new Exception();
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	
	
	
	@PostMapping("/category/")
	public ResponseEntity<?> add(@RequestBody Category elemento) {
		Category resultado = servicio.save(elemento);
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
		
	}
	
	
	@PutMapping("/category/{id}")
	public ResponseEntity<?> edit(@RequestBody Category elemento, @PathVariable Integer id) {
		if (servicio.findById(id)!= null) {
			elemento.setCatId(id);
			Category result = servicio.save(elemento);
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
			
	}
	
	@DeleteMapping("/category/{id}")
	public Category del(@PathVariable Integer id) {
		if (servicio.findById(id)!= null) {
			Category elemento = servicio.findById(id);
			servicio.del(elemento);
			return elemento;
		}else {
			return null;
		}
	}

}
