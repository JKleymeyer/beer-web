package com.beer.db;

import org.springframework.data.repository.CrudRepository;

import com.beer.business.Beer;

public interface BeerRepository extends CrudRepository<Beer, Integer> {

}
