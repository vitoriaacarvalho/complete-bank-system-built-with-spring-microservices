package com.eazybytes.accounts.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer id;
	
	private String name;
	
	private String email;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="create_dt")
	private LocalDate createDt;

	public Customer(Integer id, String name, String email, String mobileNumber, LocalDate createDt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.createDt = createDt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getCreateDt() {
		return createDt;
	}

	public void setCreateDt(LocalDate createDt) {
		this.createDt = createDt;
	}

	

}
