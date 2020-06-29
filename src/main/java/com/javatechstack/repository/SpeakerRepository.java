package com.javatechstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechstack.model.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
