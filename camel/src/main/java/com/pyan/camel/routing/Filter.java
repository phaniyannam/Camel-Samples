package com.pyan.camel.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//Add @Component annotation to run this route.

public class Filter extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("file:filter/inbox?noop=true")
		.log("Filter file name: ${header.CamelFileName}")
		.filter(xpath("/breakfast_menu"))
		.log("after File Filter: ${header.CamelFileName}")
		.to("file:filter/outbox");
	
	}

}
