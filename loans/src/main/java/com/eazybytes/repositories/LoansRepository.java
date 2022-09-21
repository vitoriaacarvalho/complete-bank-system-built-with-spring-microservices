package com.eazybytes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybytes.models.Loans;

public interface LoansRepository extends CrudRepository<Loans, Integer>{
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
