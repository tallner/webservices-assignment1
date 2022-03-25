package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
							title = "My calculator API", 
							version = "0.0.1", 
							description = 
								"This is an API for a simple calculator." +
								"<br>" + 
								"The calculator is able to process 3 arithmetics:" +
								"<ol>"
								+ "<li>Substraction</li>"
								+ "<li>Multiplication</li>"
								+ "<li>Addition</li>"
								+ "</ol>" + 
								"<br>" +
								"There is also support for selecting a spcific arithmetic in the Multiple Arithmetics endpoint."		
							))
@SpringBootApplication
public class CalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalcApplication.class, args);
	}

}
