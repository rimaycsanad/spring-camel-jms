package eu.rimaycsanad.springcameljms.service;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JmsDemoService {

	@Autowired
	private CamelContext camelContext;

	public Object sendOneWay(String text) {
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.sendBody(camelContext.getRoute("jmsSenderRoute").getEndpoint(), text);

		return true;
	}

	public Object sendTwoWay(String text) {
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		Object body = producerTemplate.requestBody(camelContext.getRoute("jmsSenderRoute").getEndpoint(), text);
		return body;
	}
}
