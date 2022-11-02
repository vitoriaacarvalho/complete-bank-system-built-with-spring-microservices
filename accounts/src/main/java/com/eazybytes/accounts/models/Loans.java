package com.eazybytes.accounts.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

		public Loans(Integer loanNumber, Integer customerId, Date startDt, String loanType, Integer totalLoan,
				Integer amountPaid, Integer outstandingAmount, String createDt) {
			super();
			this.loanNumber = loanNumber;
			this.customerId = customerId;
			this.startDt = startDt;
			this.loanType = loanType;
			this.totalLoan = totalLoan;
			this.amountPaid = amountPaid;
			this.outstandingAmount = outstandingAmount;
			this.createDt = createDt;
		}

		public Integer getLoanNumber() {
			return loanNumber;
		}

		public void setLoanNumber(Integer loanNumber) {
			this.loanNumber = loanNumber;
		}

		public Integer getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}

		public Date getStartDt() {
			return startDt;
		}

		public void setStartDt(Date startDt) {
			this.startDt = startDt;
		}

		public String getLoanType() {
			return loanType;
		}

		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}

		public Integer getTotalLoan() {
			return totalLoan;
		}

		public void setTotalLoan(Integer totalLoan) {
			this.totalLoan = totalLoan;
		}

		public Integer getAmountPaid() {
			return amountPaid;
		}

		public void setAmountPaid(Integer amountPaid) {
			this.amountPaid = amountPaid;
		}

		public Integer getOutstandingAmount() {
			return outstandingAmount;
		}

		public void setOutstandingAmount(Integer outstandingAmount) {
			this.outstandingAmount = outstandingAmount;
		}

		public String getCreateDt() {
			return createDt;
		}

		public void setCreateDt(String createDt) {
			this.createDt = createDt;
		}

}
