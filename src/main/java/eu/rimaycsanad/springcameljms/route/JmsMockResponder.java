package eu.rimaycsanad.springcameljms.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsMockResponder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:to.q").process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				String theString = (String) exchange.getIn().getBody();
				exchange.getOut().setBody(theString+".processed");
			}
		});

	}
}
