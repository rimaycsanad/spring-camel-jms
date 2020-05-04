package eu.rimaycsanad.springcameljms.route;

import eu.rimaycsanad.springcameljms.config.AppConfig;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsSenderRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:jmsSenderRoute")
				.routeId("jmsSenderRoute")
				.log("${body}")
				.to("jms:" + AppConfig.getToQueueName());

	}
}
