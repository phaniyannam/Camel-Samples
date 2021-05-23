package com.pyan.camel.transformation;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorTransformer implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		String payload = exchange.getIn().getBody(String.class);
		payload = payload + "I am getting transformed";
		exchange.getIn().setBody(payload);

	}

}
