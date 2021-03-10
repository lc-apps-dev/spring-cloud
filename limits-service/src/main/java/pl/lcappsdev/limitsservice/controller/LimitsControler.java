package pl.lcappsdev.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.lcappsdev.limitsservice.bean.Limits;
import pl.lcappsdev.limitsservice.configuration.Configuration;

@RestController
public class LimitsControler {
	
	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}

}
