package pl.lcappsdev.restfulwebservices.exception;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ExceptionResponse {
	
	private Instant timestamp;
	private String message;
	private String details;

}
