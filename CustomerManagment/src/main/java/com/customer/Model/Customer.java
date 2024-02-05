package com.customer.Model;

public class Customer {
	
	private String userid;
	private String first_name;
	private String last_name;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private long phone_number;
	
	public Customer() {
	}
	
	public Customer(String userid, String first_name, String last_name, String street, String address, String city, String state,
			String email, long phone_number) {
		super();
		this.userid = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.street = street;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone_number = phone_number;
	}
	
	public Customer( String first_name, String last_name, String street, String address, String city, String state,
			String email, long phone_number) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.street = street;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone_number = phone_number;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getUserid() {
		return userid;
	}

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", first_name=" + first_name + ", last_name=" + last_name + ", street="
				+ street + ", address=" + address + ", city=" + city + ", state=" + state + ", email=" + email
				+ ", phone_number=" + phone_number + "]";
	}

	

	
	
	
	
	
	

}
