package com.pyan.camel.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	public String hello(String name) {
		return "Hello " + name;
	}

}
