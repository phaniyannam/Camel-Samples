package com.pyan.camel.transformation;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class TransformByProcessor extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:transformation?noop=true")
		.log("${body}")
		.process(new ProcessorTransformer())
		.log("Body after transformation: ${body}")
		.to("mock:result");
		
	}

}
