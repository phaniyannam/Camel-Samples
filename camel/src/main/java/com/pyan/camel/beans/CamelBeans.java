package com.pyan.camel.beans;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CamelBeans extends RouteBuilder{
	
	@Autowired
	private CamelContext camelContext;
	
	@Autowired
	private HelloBean helloWorld;

	
	 public CamelBeans() {
		// TODO Auto-generated constructor stub
		 ProducerTemplate template = camelContext.createProducerTemplate();
		    template.sendBody("direct:start", "Pikachu");
	 
	 }
	

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("direct:start")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				String name = exchange.getIn().getBody(String.class);
				exchange.getIn().setBody(helloWorld.hello(name));	
				
			}
		})
		.log("${body}");

		
	}

}
