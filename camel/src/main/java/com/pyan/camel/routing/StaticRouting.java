package com.pyan.camel.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//Add @Component annotation to run this route.

public class StaticRouting extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:mytimer?period=5000")
			.setBody(constant("Hello World!"))
				.to("jms:queue:HELLO.WORLD");

		from("jms:queue:HELLO.WORLD")
			.log("Received a message - ${body}");

	}

}
