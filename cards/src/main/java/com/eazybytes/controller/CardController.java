package com.eazybytes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.models.Cards;
import com.eazybytes.models.Customer;
import com.eazybytes.repositories.CardRepository;

@RestController
public class CardController {
	
	@Autowired
	private CardRepository repo;
	
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer){
		List<Cards> cards=repo.findByCustomerId(customer.getCustomerId());
		if(cards != null) {
			return cards;
		}
		else {
			return null;
		}
	}
}
