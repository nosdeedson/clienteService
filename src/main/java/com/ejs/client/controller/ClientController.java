package com.ejs.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejs.client.business.ClientBusiness;
import com.ejs.client.serviceWSDL.br.com.ejs.GetAllCustomerDetailResponse;

@Controller
@RequestMapping("/")
public class ClientController {
	
	@Autowired
	private ClientBusiness clientBusiness;
	
	@GetMapping
	public ResponseEntity<?> index(){
		return ResponseEntity.ok("Index");
	}
	
	@GetMapping("customers")
	public ResponseEntity<GetAllCustomerDetailResponse> getAllCustomerDetailResponse(){
		GetAllCustomerDetailResponse response = this.clientBusiness.findAll();
		return ResponseEntity.ok(response);
	}
}
