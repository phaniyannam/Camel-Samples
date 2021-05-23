package com.pyan.camel.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//Add @Component annotation to run this route.

public class ContentBasedRouting extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:cbr/inbox?noop=true")
		.log("File Name: ${header.camelfilename}")
		.choice()
		.when(header("CamelFileName").endsWith(".xml"))
				.to("file:cbr/outbox/xml")
				.otherwise()
				.to("file:cbr/outbox/csv")
				.end();	
	}

}
