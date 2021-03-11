package pl.lcappsdev.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.lcappsdev.currencyexchangeservice.bean.CurrencyExchange;
import pl.lcappsdev.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	private static final String PORT_PROPERTY = "local.server.port";
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		
		CurrencyExchange exchange = repo.findByFromAndTo(from, to);
		
		if(exchange==null)
			throw new RuntimeException("Unable to find a data for " + from + " to " + to);
		
		return exchange;
	}

}
