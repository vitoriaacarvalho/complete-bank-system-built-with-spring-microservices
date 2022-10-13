package com.eazybytes.accounts.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts {
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "account_number")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "branch_adress")
	private String branchAddress;

	@Column(name = "create_dt")
	private LocalDate createDt;

	public Accounts(Integer customerId, Long accountNumber, String accountType, String branchAddress,
			LocalDate createDt) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchAddress = branchAddress;
		this.createDt = createDt;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public LocalDate getCreateDt() {
		return createDt;
	}

	public void setCreateDt(LocalDate createDt) {
		this.createDt = createDt;
	}
}
