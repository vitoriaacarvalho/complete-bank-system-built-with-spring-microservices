package com.eazybytes.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.models.Accounts;
import com.eazybytes.accounts.models.Customer;
import com.eazybytes.accounts.repositories.AccountRepository;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountRepository repository;
	
	@PostMapping("/myAccount")
	@Timed(value="getAccountDetails.time", description="time taken to return account details")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		Accounts accounts=repository.findByCustomerId(customer.getId());
		if (accounts != null) {
			return accounts;
		}
		else {
			return null;
		}
	}
		
	
	
	
	
	
	
}
