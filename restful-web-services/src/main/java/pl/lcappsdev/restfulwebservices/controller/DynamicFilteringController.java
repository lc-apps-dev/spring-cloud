package pl.lcappsdev.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.lcappsdev.restfulwebservices.controller.StaticFilteringController.TestBean;

@RestController
@RequestMapping("dynamic")
public class DynamicFilteringController {

	@Data
	@AllArgsConstructor
	@JsonFilter("TestBeanFilter")
	public class TestBean {
		private String field1;
		private String field2;
		private String field3;
	}
	
	
	private MappingJacksonValue filterValues(Object obj) {
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("TestBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(obj);
		mapping.setFilters(filters);
		
		return mapping;
	}

	
	@GetMapping("/get-test-bean")
	public MappingJacksonValue retrieveTestBeanDynamic() {
		
		TestBean t = new TestBean("f1", "f2", "f3");
		return filterValues(t);
	}
	
	
	@GetMapping("/get-test-bean-list")
	public MappingJacksonValue retrieveTestBeanListStatic() {	

		List<TestBean> t = Arrays.asList(new TestBean("f1", "f2", "f3"),
				new TestBean("f5", "f6", "f7")
		);
		
		return filterValues(t);
	}
	
}
