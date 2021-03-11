package pl.lcappsdev.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.lcappsdev.currencyconversionservice.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		Map<String, String> uriVariables = new HashMap<>();
		
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
			.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
					CurrencyConversion.class, uriVariables);
		
		CurrencyConversion cc = responseEntity.getBody();
		
		cc.setQuantity(quantity);
		
		cc.setTotalCalculatedAmount(cc.getQuantity().multiply(cc.getConversionMultiple()));
		
		return cc;
	}
}
