package com.pyan.camel.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//Add @Component annotation to run this route.

public class DynamicRouting extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("timer:mytimer?period=5000")
			.setBody(constant("Hello World!"))
				.setHeader("qDestination", constant("DYNAMIC.WORLD"))
				.toD("jms:queue:${header.qDestination}");
				
		from("jms:queue:DYNAMIC.WORLD")
			.log("Message received from Dynamic with body: ${body}");
		
		
	}

}
