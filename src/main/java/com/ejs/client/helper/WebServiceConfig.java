package com.ejs.client.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ejs.client.serviceWSDL.br.com.ejs.CustomerPort;
import com.ejs.client.serviceWSDL.br.com.ejs.CustomerPortService;
import com.ejs.client.soapHandler.HeaderHandlerResolver;

@Component
public class WebServiceConfig {
	
	@Autowired
	private HeaderHandlerResolver handlerResolver;

	private CustomerPortService customerPortService;
	private CustomerPort customerPort;
	
	public CustomerPortService getCustomerPortService() {
		return customerPortService;
	}

	public CustomerPort getCustomerPort() {
		return customerPort;
	}

	@Bean
	public WebServiceConfig createWeServiceConfig() {
		customerPortService = new CustomerPortService();
		customerPortService.setHandlerResolver(handlerResolver);
		customerPort = customerPortService.getCustomerPortSoap11();
		return new WebServiceConfig();
	}
}
