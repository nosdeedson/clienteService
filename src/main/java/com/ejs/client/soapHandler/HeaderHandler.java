package com.ejs.client.soapHandler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext arg0) {
		
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outBoundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(outBoundProperty) {
			try {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				SOAPElement security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
				SOAPElement userNameToken = security.addChildElement("UsernameToken", "wsse");
				SOAPElement userName = userNameToken.addChildElement("Username", "wsse");
				userName.addTextNode("ejs");
				SOAPElement password = userNameToken.addChildElement("Password", "wsse");
				password.addTextNode("123");
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		}
		
		return outBoundProperty;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
