package com.eazybytes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.config.CardsService;
import com.eazybytes.models.Cards;
import com.eazybytes.models.Customer;
import com.eazybytes.models.Properties;
import com.eazybytes.repositories.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class CardController {
	
	@Autowired
	private CardRepository repo;
	
	@Autowired
	private CardsService cardsConfig;
	
	
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
	
	@GetMapping("/cards/properties")
	public String getPropertyDetails() throws JsonProcessingException{
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties=new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(), cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
		String jsonStr= ow.writeValueAsString(properties);
		return jsonStr;
}
	
	
	
	
	
	
	
	
}
