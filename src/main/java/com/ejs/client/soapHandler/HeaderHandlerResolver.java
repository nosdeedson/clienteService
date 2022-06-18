package com.ejs.client.soapHandler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.springframework.stereotype.Service;

@Service
public class HeaderHandlerResolver implements HandlerResolver {

	@SuppressWarnings("rawtypes")
	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlers = new ArrayList<Handler>();
		HeaderHandler hh = new HeaderHandler();
		handlers.add(hh);
		return handlers;
	}

}
