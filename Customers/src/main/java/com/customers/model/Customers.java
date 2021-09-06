package com.customers.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customers_transaction")
public class Customers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cust_id")
	private int custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="transaction_date")
	private Date transactionDate;
	
	
	@Column(name="transation_value")
	private int transationValue;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getTransationValue() {
		return transationValue;
	}

	public void setTransationValue(int transationValue) {
		this.transationValue = transationValue;
	}
	
	
	

}
