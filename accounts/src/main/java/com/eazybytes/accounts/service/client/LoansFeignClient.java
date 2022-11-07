package com.eazybytes.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eazybytes.accounts.models.Customer;
import com.eazybytes.accounts.models.Loans;

@FeignClient("loans")
public interface LoansFeignClient {
	@RequestMapping(method=RequestMethod.POST, value="myLoans", consumes="application/json")
	List<Loans> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationId,@RequestBody Customer customer);
}
