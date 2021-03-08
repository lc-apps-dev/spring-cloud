package pl.lcappsdev.restfulwebservices.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details about user entity")
public class User {
	
	private Integer id;
	
	@Size(min=2, message="Name should have at least 2 characters")
	@ApiModelProperty(notes = "Name should have at least 2 characters")
	private String name;
	
	@Past(message="Provided date should be past date")
	@ApiModelProperty(notes = "Birth date has to be provided as a past date")
	private LocalDate birthDate;

}
