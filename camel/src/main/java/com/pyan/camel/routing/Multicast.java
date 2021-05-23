package com.pyan.camel.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// Add @Component annotation to run this route.

public class Multicast extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:multicast/inbox?noop=true")
			.multicast().to("direct:out1", "direct:out2", "direct:out3")
			.end();
		
		from("direct:out1")
		.log("File saved via Multicast 1st Route")
		.to("file:multicast/out1");
		
		from("direct:out2")
		.log("File saved via Multicast 2nd Route")
		.to("file:multicast/out2");
		
		from("direct:out3")
		.log("File saved via Multicast 3rd Route")
		.to("file:multicast/out3");
			
	}

}
