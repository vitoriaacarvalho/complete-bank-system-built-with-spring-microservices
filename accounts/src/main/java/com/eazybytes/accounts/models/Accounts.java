package com.eazybytes.accounts.models;

import java.time.LocalDate;

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
public class Accounts {
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="account_number")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountNumber;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="branch_adress")
	private String branchAddress;
	
	@Column(name="create_dt")
	private LocalDate createDt;
}
