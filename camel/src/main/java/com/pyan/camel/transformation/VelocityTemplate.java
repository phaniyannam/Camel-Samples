package com.pyan.camel.transformation;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


public class VelocityTemplate extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:xslt?noop=true&include=.*xml")
		.convertBodyTo(String.class)
		.to("velocity:templates/velocity.vm")
		.log("Template Result: ${body}")
		.to("file:velocity");
		
	}

}
