package com.camilo.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camilo.app.entity.user;
import com.camilo.app.service.UserServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("api/users")
public class userController {

	@Autowired
	private UserServices usuarioService;
	

	@GetMapping
	public List <user> listar() {
		List<user> usuarios = StreamSupport.stream(
				usuarioService.findall().spliterator(),false)
				.collect(Collectors.toList());
		return usuarios;
	}
	

		@GetMapping("/{id}")
		public ResponseEntity<?> show(@PathVariable(value="id") Long idcli) {
			Optional<user> ucliente=usuarioService.findbyid(idcli);
			if(!ucliente.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(ucliente);
		}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody user user, @PathVariable (value="id") Long idcli) {
		Optional<user> userAct=usuarioService.findbyid(idcli);
		if(!userAct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		userAct.get().setName(user.getName());
		userAct.get().setSurname(user.getSurname());
		userAct.get().setEmail(user.getEmail());
		userAct.get().setEnable(user.getEnable());
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(userAct.get()));
	}
	
	

		@PostMapping
	    public ResponseEntity<?> guardar(@RequestBody user u){
	          return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(u));
	    }
	
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id) {
		if(!usuarioService.findbyid(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deletebyid(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
