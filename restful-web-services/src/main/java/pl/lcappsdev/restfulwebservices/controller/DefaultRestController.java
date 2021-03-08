package pl.lcappsdev.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import pl.lcappsdev.restfulwebservices.dto.MessageContainer;

@RestController
public class DefaultRestController {
	
	@Autowired
	private MessageSource messageSource;

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
	
	@GetMapping(path = "/hello-i18n")
	public String getHelloI18N(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping(path = "/hello-i18n/v2")
	public String getHelloI18NBasedByContextLocale() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping(path = "/swagger")
	public RedirectView redirectoToSwagger() {
		return new RedirectView("swagger-ui/index.html");
	}
	
	
}
