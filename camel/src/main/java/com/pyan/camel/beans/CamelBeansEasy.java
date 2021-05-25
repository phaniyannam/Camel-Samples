package com.pyan.camel.beans;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CamelBeansEasy extends RouteBuilder {

	@Autowired
	private HelloBean helloWorld;

	/*
	 * TIP
	 * 
	 * In the Java DSL, you don’t have to pre register the bean in the registry.
	 * Instead, you can provide the class name of the bean, and Camel will
	 * instantiate the bean on startup. The previous example could be written like
	 * this: from("direct:hello").bean(HelloBean.class);.
	 */

	public void configure() throws Exception {
		from("direct:hello").bean(helloWorld, "hello") // Or can be just .bean(helloWorld) since it has only 1 method
				.log("${body}");
	}

}
