package com.javatechstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechstack.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
