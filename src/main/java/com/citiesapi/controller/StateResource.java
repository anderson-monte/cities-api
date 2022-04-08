package com.citiesapi.controller;

import com.citiesapi.model.State;
import com.citiesapi.repository.StateRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateResource {

	@Autowired
	private StateRepository repository;

	@GetMapping
	public List<State> staties() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public State state(@PathVariable Long id) {
		return repository.findById(id).get();
	}
}
