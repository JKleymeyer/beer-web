package com.beer.db;

import org.springframework.data.repository.CrudRepository;

import com.beer.business.OnTap;

public interface OnTapRepository extends CrudRepository<OnTap, Integer> {

}
