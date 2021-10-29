package org.springmvcdemo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	@NotNull(message = "type is required")
	private String type;

	@Column(name = "amount")
	@NotNull(message = "amount is required")
	private Long amount;

	@Column(name = "booked_date")
	private Date bookedDate;

	@Column(name = "number_of_emi")
	private int numberOfEmi;

	@ManyToOne
	@JoinColumn(name = "customer", nullable = false)
	private Customer customer;

	@Transient
	private int accountNumber;

	public Loan() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getNumberOfEmi() {
		return numberOfEmi;
	}

	public void setNumberOfEmi(int numberOfEmi) {
		this.numberOfEmi = numberOfEmi;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", type=" + type + ", amount=" + amount + ", bookedDate=" + bookedDate + ", customer="
				+ customer + "]";
	}

}
