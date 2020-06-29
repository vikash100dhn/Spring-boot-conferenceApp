package com.javatechstack.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javatechstack.model.Session;
import com.javatechstack.repository.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

	@Autowired
	private SessionRepository sessionRepository;
	
	@GetMapping("/{id}")
	public Session get(@PathVariable Long id)
	{
		return sessionRepository.getOne(id);
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Session create(@RequestBody final Session session)
	{
		return sessionRepository.saveAndFlush(session);
	}
	
	@GetMapping
	public List<Session> list(){
		return sessionRepository.findAll();
	}
	
	@DeleteMapping("{/id}")
	public void delete(@PathVariable Long id)
	{
		//need to check child records before deleting
		sessionRepository.deleteById(id);
	}
	@PutMapping({"/id"})
	public Session update(@PathVariable Long id, @RequestBody Session session)
	{
		Session existingSession = sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, existingSession, "session_id");
		return sessionRepository.saveAndFlush(existingSession);
	}
	
}
