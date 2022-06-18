package com.ejs.client.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejs.client.helper.WebServiceConfig;
import com.ejs.client.model.CustomerDTO;
import com.ejs.client.serviceWSDL.br.com.ejs.CustomerDetail;
import com.ejs.client.serviceWSDL.br.com.ejs.DeleteCustomerDetailRequest;
import com.ejs.client.serviceWSDL.br.com.ejs.DeleteCustomerDetailResponse;
import com.ejs.client.serviceWSDL.br.com.ejs.GetAllCustomerDetailRequest;
import com.ejs.client.serviceWSDL.br.com.ejs.GetAllCustomerDetailResponse;
import com.ejs.client.serviceWSDL.br.com.ejs.GetCustomerDetailRequest;
import com.ejs.client.serviceWSDL.br.com.ejs.GetCustomerDetailResponse;
import com.ejs.client.serviceWSDL.br.com.ejs.SaveCustomerDetailRequest;
import com.ejs.client.serviceWSDL.br.com.ejs.SaveCustomerDetailResponse;

@Service
public class ClientBusiness {

	private WebServiceConfig webServiceConfig;
	
	@Autowired	
	public ClientBusiness(WebServiceConfig webServiceConfig) {
		this.webServiceConfig = webServiceConfig;
	}


	public GetAllCustomerDetailResponse findAll() {
		GetAllCustomerDetailResponse response = new GetAllCustomerDetailResponse();
		
		response = webServiceConfig.getCustomerPort().getAllCustomerDetail(new GetAllCustomerDetailRequest());
		
		return response;
	}

	public GetCustomerDetailResponse findById(Integer id) {
		
		GetCustomerDetailResponse response = new GetCustomerDetailResponse();
		GetCustomerDetailRequest customerDetailRequest = new GetCustomerDetailRequest();
		customerDetailRequest.setId(id);
		response = webServiceConfig.getCustomerPort().getCustomerDetail(customerDetailRequest);
		return response;
	}

	public DeleteCustomerDetailResponse delete(Integer id) {
		DeleteCustomerDetailRequest request = new DeleteCustomerDetailRequest();
		request.setId(id);
		DeleteCustomerDetailResponse response = new DeleteCustomerDetailResponse();
        response = webServiceConfig.getCustomerPort().deleteCustomerDetail(request);
		return response;
	}
	
	public SaveCustomerDetailResponse saveCustomerDetailResponse(CustomerDTO customerDTO) {
		CustomerDetail customerDetail = customerDTO.toCustomerDetail();
		SaveCustomerDetailRequest request = new SaveCustomerDetailRequest();
		request.setCustomerDetail(customerDetail);
		SaveCustomerDetailResponse response = webServiceConfig.getCustomerPort().saveCustomerDetail(request);
		return response;
	}
	
	
}
