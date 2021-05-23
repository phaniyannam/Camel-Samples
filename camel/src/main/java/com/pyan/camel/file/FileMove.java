package com.pyan.camel.file;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//Add @Component annotation to run this route.

public class FileMove extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		from("file:data/inbox?noop=true")
			.log("${headers.CamelFileName}")
				.to("file:data/outbox");

	}

}
