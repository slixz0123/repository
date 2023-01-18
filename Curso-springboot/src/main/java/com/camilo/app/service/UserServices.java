package com.camilo.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.camilo.app.entity.user;

public interface UserServices  {
public  Iterable<user>findall();
public  Page<user>findall(Pageable pageable);
public  Optional<user>findbyid(Long Id);
public  user save(user user);
public  void  deletebyid(Long id);

}
