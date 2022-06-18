package com.ejs.client.business;

import org.springframework.stereotype.Service;

import com.ejs.client.serviceWSDL.br.com.ejs.CustomerPort;
import com.ejs.client.serviceWSDL.br.com.ejs.CustomerPortService;
import com.ejs.client.serviceWSDL.br.com.ejs.GetAllCustomerDetailRequest;
import com.ejs.client.serviceWSDL.br.com.ejs.GetAllCustomerDetailResponse;
import com.ejs.client.soapHandler.HeaderHandlerResolver;

@Service
public class ClientBusiness {
	
	public GetAllCustomerDetailResponse findAll() {
		GetAllCustomerDetailResponse response = new GetAllCustomerDetailResponse();
		
		CustomerPortService customerPortService = new CustomerPortService();
		
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		
		customerPortService.setHandlerResolver(handlerResolver);
		
		CustomerPort customerPort = customerPortService.getCustomerPortSoap11();
		
		response = customerPort.getAllCustomerDetail(new GetAllCustomerDetailRequest());
		
		return response;
	}
	
}
