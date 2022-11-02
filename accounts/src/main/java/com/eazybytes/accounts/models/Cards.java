package com.eazybytes.accounts.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
	public Cards(Integer cardId, Integer customerId, String cardNumber, String cardType, Integer totalLimit,
			Integer amountUsed, Integer availableAmount, Date createDt) {
		super();
		this.cardId = cardId;
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.totalLimit = totalLimit;
		this.amountUsed = amountUsed;
		this.availableAmount = availableAmount;
		this.createDt = createDt;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(Integer totalLimit) {
		this.totalLimit = totalLimit;
	}

	public Integer getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(Integer amountUsed) {
		this.amountUsed = amountUsed;
	}

	public Integer getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(Integer availableAmount) {
		this.availableAmount = availableAmount;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
	
}
