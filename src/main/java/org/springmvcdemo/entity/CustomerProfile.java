package org.springmvcdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "customer_profile")
public class CustomerProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	@Email(message = "Please enter a valid email")
	private String email;

	@Column(name = "phone")
	@NotNull(message = "phone is required")
	private String phone;

	@Column(name = "addressLine1")
	@NotNull(message = "addressLine1 is required")
	private String addressLine1;

	@Column(name = "addressLine2")
	@NotNull(message = "addressLine2 is required")
	private String addressLine2;

	@Column(name = "city")
	@NotNull(message = "city is required")
	private String city;

	@Column(name = "state")
	@NotNull(message = "state is required")
	private String state;

	@Column(name = "zip")
	@NotNull(message = "zip is required")
	private String zip;
	
	@Transient
	private int account;

	public CustomerProfile() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "CustomerProfile [id=" + id + ", email=" + email + ", phone=" + phone + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

}
