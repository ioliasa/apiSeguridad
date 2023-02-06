package com.jacaranda.miPrimerApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miPrimerApi.model.Elements;

public interface ElementsRepository extends JpaRepository<Elements,  Long> {

}
