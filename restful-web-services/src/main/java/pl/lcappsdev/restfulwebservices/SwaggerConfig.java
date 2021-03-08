package pl.lcappsdev.restfulwebservices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	public static final Contact DEFAULT_CONTACT = new Contact(
		  "LC-APPS-DEV",
		  "https://github.com/lc-apps-dev/",
		  "");
	  
  	public static final ApiInfo DEFAULT_API_INFO
	      = new ApiInfo(
	      "Api Documentation for test spring boot cloud project",
	      "Api Documentation for test spring boot cloud project",
	      "1.0",
	      "urn:tos",
	      DEFAULT_CONTACT,
	      "Apache 2.0",
	      "http://www.apache.org/licenses/LICENSE-2.0",
	      new ArrayList<>());
  
  	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>();
  
  	
  	static {
  		DEFAULT_PRODUCES_AND_CONSUMES.add("application/json");
  	}
  
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES);
	}
}
