package pl.lcappsdev.restfulwebservices.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	
	private Integer id;
	private String namel;
	private LocalDate birthDate;

}
