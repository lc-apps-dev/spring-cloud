package pl.lcappsdev.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class FilteringController {

	@Data
	@AllArgsConstructor
	@JsonIgnoreProperties(value = {"field1"})
	public class TestBean {
		private String field1;
		private String field2;
		
		@JsonIgnore
		private String field3;
	}
	
	@GetMapping("/get-test-bean")
	public TestBean retrieveTestBean() {
		return new TestBean("f1", "f2", "f3");
	}
	
	@GetMapping("/get-test-bean-list")
	public List<TestBean> retrieveTestBeanList() {
		return Arrays.asList(new TestBean("f1", "f2", "f3"),
				new TestBean("f5", "f6", "f7")
		);
	}
}
