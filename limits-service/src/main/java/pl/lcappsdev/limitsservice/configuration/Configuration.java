package pl.lcappsdev.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
@ConfigurationProperties("limits-service")
@Controller
public class Configuration {

	private int minimum;
	private int maximum;
}
