package com.pyan.camel.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CamelBeansByProcessor extends RouteBuilder {

	@Autowired
	private HelloBean helloWorld;

	@Override
	public void configure() throws Exception {

		from("direct:start")
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				String name = exchange.getIn().getBody(String.class);
				exchange.getIn().setBody(helloWorld.hello(name));

			}
		}).log("${body}");

	}

}
