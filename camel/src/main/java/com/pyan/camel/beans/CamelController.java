package com.pyan.camel.beans;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {

	@Autowired
	ProducerTemplate producerTemplate;

	@GetMapping("/beanProcessor/{id}")
	public void startCamel(@PathVariable String id) {
		producerTemplate.sendBody("direct:start", id);
	}

	@GetMapping("/beansEasy/{id}")
	public void beansEasy(@PathVariable String id) {
		producerTemplate.sendBody("direct:hello", id);
	}

	@GetMapping("/beansTo/{id}")
	public void beansTo(@PathVariable String id) {
		producerTemplate.sendBody("direct:hello1", id);
	}

}
