package eu.rimaycsanad.springcameljms.controller;

import eu.rimaycsanad.springcameljms.service.JmsDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsDemoController {

	@Autowired
	private JmsDemoService service;

	@RequestMapping(value = "oneway/{text}", method = RequestMethod.GET)
	public Object oneway(@PathVariable("text") String text) {
		return service.sendOneWay(text);
	}

	@RequestMapping(value = "twoway/{text}", method = RequestMethod.GET)
	public Object twoway(@PathVariable("text") String text) {
		return service.sendTwoWay(text);
	}
}
