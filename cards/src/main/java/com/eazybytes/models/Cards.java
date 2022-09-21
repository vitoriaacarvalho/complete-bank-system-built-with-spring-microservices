package com.eazybytes.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Cards {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="card_id")
	private Integer cardId;
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="card_type")
	private String cardType;

	@Column(name="total_limit")
	private Integer totalLimit;
	
	@Column(name="amount_used")
	private Integer amountUsed;
	
	@Column(name="available_amount")
	private Integer availableAmount;
	
	@Column(name="create_dt")
	private Date createDt;
}
