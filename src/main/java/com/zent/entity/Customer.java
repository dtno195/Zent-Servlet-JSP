package com.zent.entity;

import java.util.Date;

public class Customer {
	private Long customerId;
	private String name;
	private String address;
	private String phone;
	private String email;
	private Date date;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(Long customerId, String name, String address, String phone, String email, Date date) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
