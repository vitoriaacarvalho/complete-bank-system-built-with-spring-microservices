package com.eazybytes.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eazybytes.accounts.models.Cards;
import com.eazybytes.accounts.models.Customer;

@FeignClient("cards")
public interface CardsFeignClient {

	@RequestMapping(method= RequestMethod.POST, value="myCards", consumes="application/json") 
	List<Cards> getCardsDetails(@RequestHeader("eazybank-correlation-id")String correlationId, @RequestBody Customer customer);
}
