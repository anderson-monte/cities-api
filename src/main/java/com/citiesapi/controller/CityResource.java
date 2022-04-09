package com.citiesapi.controller;

import com.citiesapi.model.City;
import com.citiesapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityResource {
	
	@Autowired
	private CityRepository repository;

	@GetMapping
	public List<City> cities() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public City city(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	 
}
