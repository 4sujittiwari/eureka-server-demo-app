package com.example.customer.dto;

public class Customer {

	private String name;
	private String city;
	private String server;

	public Customer(String name, String city, String server) {
		super();
		this.name = name;
		this.city = city;
		this.server = server;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
