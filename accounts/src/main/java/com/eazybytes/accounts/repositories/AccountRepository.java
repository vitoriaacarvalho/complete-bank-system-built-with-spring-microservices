package com.eazybytes.accounts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.accounts.models.Accounts;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Long>{
	public Accounts findByCustomerId(int customerId);
}
