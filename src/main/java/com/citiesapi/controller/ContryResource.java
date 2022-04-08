package com.citiesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiesapi.model.Contry;
import com.citiesapi.repository.ContryRepository;

@RestController
@RequestMapping("/contries")
public class ContryResource {

	@Autowired
	private ContryRepository repository;

	@GetMapping
	public List<Contry> countries() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Contry contry(@PathVariable Long id) {
		return repository.findById(id).get();
	}

}