package pl.lcappsdev.currencyexchangeservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CircuitBreakerController {
	
	
	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	public String sampleApi() {
		
		log.info("sampleApi() call received");
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:808/some-dummy-url", String.class);
		return forEntity.getBody();
	}
	
	public String hardcodedResponse(Exception e) {
		return "fallback-response";
	}
	
	@GetMapping("/sample-api2")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	public String sampleApi2() {
		
		log.info("sampleApi2() call received");
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:808/some-dummy-url", String.class);
		return forEntity.getBody();
	}
	
	
	@GetMapping("/sample-api3")
	@RateLimiter(name = "default")	//10s -> max 10000 calls to the api
	public String sampleApi3() {
		
		log.info("sampleApi3() call received");
		
		return "sampleApi3";
	}
	
	@GetMapping("/sample-api4")
	@Bulkhead(name = "default")	//10s -> max 10000 calls to the api
	public String sampleApi4() {
		
		log.info("sampleApi4() call received");
		
		return "sampleApi4";
	}
}
