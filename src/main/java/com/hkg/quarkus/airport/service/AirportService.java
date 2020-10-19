package com.hkg.quarkus.airport.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.hkg.quarkus.airport.entity.Airport;
import com.hkg.quarkus.airport.repository.AirportRepository;

@ApplicationScoped
public class AirportService {
	
	@Inject
	AirportRepository airportRepository;
	
	
	@Transactional
	public Airport save(Airport airport) {
		return airportRepository.createOrUpdate(airport);
	}
	
	public List<Airport> getAllAirports() {
		return airportRepository.getAllAirports();
	}
	
    @Transactional
	public void deleteByid(Long id) {
		airportRepository.deleteById(id);
	}
	

}
