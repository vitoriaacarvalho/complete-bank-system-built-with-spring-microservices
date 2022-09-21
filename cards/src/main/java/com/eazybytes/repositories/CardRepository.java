package com.eazybytes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybytes.models.Cards;

public interface CardRepository extends CrudRepository<Cards, Integer>{
	List<Cards> findByCustomerId(int customerId);
}
