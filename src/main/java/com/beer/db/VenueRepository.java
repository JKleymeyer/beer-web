package com.beer.db;

import org.springframework.data.repository.CrudRepository;

import com.beer.business.Venue;

public interface VenueRepository extends CrudRepository<Venue, Integer> {

}
