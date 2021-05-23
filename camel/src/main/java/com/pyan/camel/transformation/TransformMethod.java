package com.pyan.camel.transformation;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class TransformMethod extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:transformation?noop=true")
		.log("${body}")
		.transform().constant("OK (Existing body was transformed to OK)")
		.log("Body after transformation: ${body}");
		
	}

}
