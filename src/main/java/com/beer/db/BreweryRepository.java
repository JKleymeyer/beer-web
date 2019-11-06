package com.beer.db;

import org.springframework.data.repository.CrudRepository;

import com.beer.business.Brewery;

public interface BreweryRepository extends CrudRepository<Brewery, Integer> {

}
