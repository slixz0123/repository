package com.camilo.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camilo.app.entity.user;
import com.camilo.app.repository.UserRepository;



@Service
public class Userserviceimpl implements UserServices {
@Autowired
	
	private UserRepository userRepository;


	@Override
	@Transactional
	public Iterable<user> findall() {
		
		
		
		return userRepository.findAll();
	}

	
	@Override
	@Transactional
	public Page<user> findall(Pageable pageable) {
		
		
		
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Optional<user> findbyid(Long Id) {
	
		
		
		return userRepository.findById(Id);
	}

	@Override
	@Transactional
	public user save(user user) {
		
		return  userRepository.save(user);
	}

	@Override
	@Transactional
	public void deletebyid(Long id) {
		userRepository.deleteById(id);
		
	}

	
}
