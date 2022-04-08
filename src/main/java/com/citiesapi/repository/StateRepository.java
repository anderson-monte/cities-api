package com.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiesapi.model.State;

public interface StateRepository extends JpaRepository<State, Long> {
}
