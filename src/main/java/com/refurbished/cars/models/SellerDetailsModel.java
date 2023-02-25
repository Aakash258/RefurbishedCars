package com.refurbished.cars.models;

public class SellerDetailsModel {
	private int seller_id;
	private String company_logo;
	private String company_name;
	private String email;
	private String city;
	private String state;
	private String address;
	private int pincode;
	private int phone;

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getCompany_logo() {
		return company_logo;
	}

	public void setCompany_logo(String company_logo) {
		this.company_logo = company_logo;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public SellerDetailsModel(int seller_id, String company_logo, String company_name, String email, String city,
			String state, String address, int pincode, int phone) {
		super();
		this.seller_id = seller_id;
		this.company_logo = company_logo;
		this.company_name = company_name;
		this.email = email;
		this.city = city;
		this.state = state;
		this.address = address;
		this.pincode = pincode;
		this.phone = phone;
	}

	public SellerDetailsModel() {
		super();
	}

}
