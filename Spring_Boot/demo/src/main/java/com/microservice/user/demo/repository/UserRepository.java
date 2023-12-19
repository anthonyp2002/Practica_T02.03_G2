package com.microservice.user.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.microservice.user.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    
}