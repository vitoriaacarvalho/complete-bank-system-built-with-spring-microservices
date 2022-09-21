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
public class Loans {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="loan_number")
	private Integer loanNumber;
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name="loan_type")
	private String loanType;
	
	@Column(name="total_loan")
	private Integer totalLoan;
	
	@Column(name="amount_paid")
	private Integer amountPaid;
	
	@Column(name="outstanding_amount")
	private Integer outstandingAmount;
	
	@Column(name="create_dt")
	private String createDt;
}
