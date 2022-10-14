package com.eazybytes.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.config.AccountsService;
import com.eazybytes.accounts.models.Accounts;
import com.eazybytes.accounts.models.Customer;
import com.eazybytes.accounts.models.Properties;
import com.eazybytes.accounts.repositories.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private AccountsService accountsConfig;
	
	@PostMapping("/myAccount")
	@Timed(value="getAccountDetails.time", description="time taken to return account details")
	public Accounts getAccountsDetails(@RequestBody Customer customer) {
		Accounts accounts=repository.findByCustomerId(customer.getId());
		if (accounts != null) {
			return accounts;
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/accounts/properties")
	public String getPropertyDetails() throws JsonProcessingException{
		ObjectWriter ow=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties=new Properties(accountsConfig.getMsg(),accountsConfig.getBuildVersion(), 
				accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
		String jsonStr=ow.writeValueAsString(properties);
		return jsonStr;
	}
	
	
	
	
	
	
	
	
	
	
}
