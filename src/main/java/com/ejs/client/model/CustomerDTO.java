package com.ejs.client.model;

import com.ejs.client.serviceWSDL.br.com.ejs.CustomerDetail;

public class CustomerDTO {
	
	private Integer id;
	private String name;
	private String email;
	private String phone;
	
	public CustomerDetail toCustomerDetail() {
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setEmail(this.email);
		if(this.id != null) {
			customerDetail.setId(this.id);
		}
		customerDetail.setName(this.name);
		customerDetail.setPhone(this.phone);
		return customerDetail;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
