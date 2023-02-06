package com.jacaranda.miPrimerApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimerApi.model.Elements;
import com.jacaranda.miPrimerApi.repository.ElementsRepository;


@Service
public class ElementsService {

	@Autowired
	ElementsRepository repositorio;
	
	public List<Elements> findAll(){
		return repositorio.findAll();
	}
	
	public Elements findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Elements save(Elements e) {
		return repositorio.save(e);
	}
	
	public void del(Elements e) {
		repositorio.delete(e);
	}
}
