package com.eazybytes.accounts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.config.AccountsService;
import com.eazybytes.accounts.models.Accounts;
import com.eazybytes.accounts.models.Cards;
import com.eazybytes.accounts.models.Customer;
import com.eazybytes.accounts.models.CustomerDetails;
import com.eazybytes.accounts.models.Loans;
import com.eazybytes.accounts.models.Properties;
import com.eazybytes.accounts.repositories.AccountRepository;
import com.eazybytes.accounts.service.client.CardsFeignClient;
import com.eazybytes.accounts.service.client.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.core.annotation.Timed;

@RestController
public class AccountController {
	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private LoansFeignClient loansFeignClient;
	
	@Autowired
	private CardsFeignClient cardsFeignClient;
	
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
	
	@PostMapping("/myCustomerDetails")
	@CircuitBreaker(name="detailsForCustomerSupportApp", fallbackMethod="myCustomerDetailsFallBack")
	public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
		Accounts accounts=repository.findByCustomerId(customer.getId());
		List<Loans> loans=loansFeignClient.getLoansDetails(customer);
		List<Cards> cards= cardsFeignClient.getCardDetails(customer);
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		customerDetails.setCards(cards);
		return customerDetails;
	}
	
	private CustomerDetails myCustomerDetailsFallBack(Customer customer, Throwable t) {
		Accounts accounts=repository.findByCustomerId(customer.getId());
		List<Loans> loans=loansFeignClient.getLoansDetails(customer);
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		return customerDetails;
	}	
}
