package com.camilo.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.io.Serializable;

import jakarta.persistence.*;
@Entity
@Table(name="users")
public class user implements Serializable {
	
    private static final long serialVersionUID = -2674154731849444520L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	
	@Column(length = 50)
	private String name;
	
	
	private String surname;
	
	@Column(name = "mail" , nullable= false , unique =true , length = 50)
	private String email;
	
	private Boolean enable;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	
	
	
	
	
	
	
}
