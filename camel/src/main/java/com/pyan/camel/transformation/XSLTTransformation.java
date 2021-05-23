package com.pyan.camel.transformation;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


public class XSLTTransformation extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("file:xslt?noop=true&include=.*xml")
		.log("XML before Transformation: ${body}")
		.to("xslt:book.xslt")
		.log("XML after Transformation: ${body}");
		
	}

}
