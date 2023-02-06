package com.jacaranda.miPrimerApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimerApi.model.Users;
import com.jacaranda.miPrimerApi.repository.UsersRepository;


@Service
public class UserService implements UserDetailsService {
	@Autowired
	UsersRepository repositorio;
	
	public List<Users> findAll(){
		return repositorio.findAll();
	}
	
	public Users findById(String id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Users save(Users e) {
		return repositorio.save(e);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Users user = repositorio.findById(username).orElse(null);
			if (user == null ) {
				throw new UsernameNotFoundException("User not found");
			}
			return user;
			
	}
	
}
