package pl.lcappsdev.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lcappsdev.restfulwebservices.dto.MessageContainer;

@RestController
public class DefaultRestController {

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String getHelloMessage() {
		return "Hello from " + this.getClass().getName();
	}
	
	
	@GetMapping(path = "/getBean")
	public MessageContainer getHelloBean() {
		return new MessageContainer("Hello from " + this.getClass().getName());
	}
	
	@GetMapping(path = "/getBean/{message}")
	public MessageContainer getHelloBeanWithParam(@PathVariable String message) {
		return new MessageContainer("Hello! " + message);
	}
}
