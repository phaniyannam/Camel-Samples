package com.pyan.camel.beans;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CamelBeansTo extends RouteBuilder{
	
	
	@Autowired
	private HelloBean helloBean;

	@Override
	public void configure() throws Exception {

		from("direct:hello1")
		  .to("bean:helloBean?method=hello")
		  .log("${body}");
		
	}

}
