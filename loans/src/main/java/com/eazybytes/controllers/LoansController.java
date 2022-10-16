package com.eazybytes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.config.LoansService;
import com.eazybytes.models.Customer;
import com.eazybytes.models.Loans;
import com.eazybytes.models.Properties;
import com.eazybytes.repositories.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class LoansController {
	
	@Autowired 
	private LoansRepository repo;
	
	@Autowired
	private LoansService loansConfig;
	
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
	
	@GetMapping("/loans/properties")
	public String getPropertyDetails() throws JsonProcessingException{
		ObjectWriter ow=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties=new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(), loansConfig.getMailDetails(), loansConfig.getActiveBranches());
		String jsonStr=ow.writeValueAsString(properties);
		return jsonStr;
	}
	
	
	
	
	
	
	
	
	
	
	
}
