package com.eazybytes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.models.Customer;
import com.eazybytes.models.Loans;
import com.eazybytes.repositories.LoansRepository;

@RestController
public class LoansController {
	
	@Autowired 
	private LoansRepository repo;
	
	
	@PostMapping("/myLoans")
	public List<Loans> getAccountDetails(@RequestBody Customer customer){
		List<Loans> loans= repo.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if (loans != null) {
			return loans;
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
