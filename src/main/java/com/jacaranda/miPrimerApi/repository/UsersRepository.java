package com.jacaranda.miPrimerApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miPrimerApi.model.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

}
