package com.hkg.quarkus.airport.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.hkg.quarkus.airport.entity.Airport;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AirportRepository implements PanacheRepository<Airport> {

	
	/***
	 * 
	 * @param airport
	 * @return
	 */
	public Airport createOrUpdate(Airport airport) {		
		 this.persist(airport);
		 return airport;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Airport> getAllAirports() {
		return this.listAll();
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		this.deleteById(id);
	}

	

}