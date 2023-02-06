package com.jacaranda.miPrimerApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimerApi.model.Category;
import com.jacaranda.miPrimerApi.model.Elements;
import com.jacaranda.miPrimerApi.repository.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	CategoryRepository repositorio;
	
	public List<Category> findAll(){
		return repositorio.findAll();
	}
	
	public Category findById(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Category save(Category e) {
		return repositorio.save(e);
	}
	
	public void del(Category e) {
		repositorio.delete(e);
	}
}
