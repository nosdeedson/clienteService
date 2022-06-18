package com.ejs.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejs.client.business.ClientBusiness;
import com.ejs.client.model.CustomerDTO;
import com.ejs.client.serviceWSDL.br.com.ejs.CustomerDetail;
import com.ejs.client.serviceWSDL.br.com.ejs.DeleteCustomerDetailResponse;
import com.ejs.client.serviceWSDL.br.com.ejs.GetAllCustomerDetailResponse;
import com.ejs.client.serviceWSDL.br.com.ejs.GetCustomerDetailResponse;
import com.ejs.client.serviceWSDL.br.com.ejs.SaveCustomerDetailResponse;

@Controller
@RequestMapping("customers")
public class ClientController {
	
	@Autowired
	private ClientBusiness clientBusiness;
	
	@GetMapping("index")
	public ResponseEntity<?> index(){
		return ResponseEntity.ok("Index");
	}
	
	@GetMapping
	public ResponseEntity<GetAllCustomerDetailResponse> getAllCustomerDetailResponse(){
		GetAllCustomerDetailResponse response = this.clientBusiness.findAll();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<GetCustomerDetailResponse> getCustomerDetailResponse(
			@PathVariable(name = "id") Integer id){
		GetCustomerDetailResponse response = this.clientBusiness.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<DeleteCustomerDetailResponse> deleteCustomerDetailResponse(
			@PathVariable(name="id") Integer id){
		DeleteCustomerDetailResponse status = this.clientBusiness.delete(id);
		return ResponseEntity.ok(status);
	}
	
	@PostMapping
	public ResponseEntity<SaveCustomerDetailResponse> saveCustomerDetailResponse(
			@RequestBody CustomerDTO customerDTO){
		SaveCustomerDetailResponse response = this.clientBusiness.saveCustomerDetailResponse(customerDTO);
		return ResponseEntity.ok(response);
	}
	
	
}
