package com.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiesapi.model.Contry;

public interface ContryRepository extends JpaRepository<Contry, Long> {
}
