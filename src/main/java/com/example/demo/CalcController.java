package com.example.demo;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;


@RestController
public class CalcController implements ErrorController {
	
	private CalcService myCalcService = new CalcService();
	
	//start page
	@Hidden
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET, 
			produces = MediaType.TEXT_HTML_VALUE)
	public String start() {
		String result = "";
		result += "<html><head><title>This is my calculator</title></head>";
		result += "<body>";
		result += "<h4>This is my calculator start page</h4>";

		result += "</body></html>";
		return result;
	}
	
	//substraction operation of two values
	@Operation(summary = "Substraction GET request", description = "Substraction of two values", tags="Single arithmetics")
	@GetMapping("/sub")
	public String sub(String nr1, String nr2) {
		 return myCalcService.Substraction(nr1, nr2);
	}
	
	//addition operation of two values
	@Operation(summary = "Addition GET request", description = "Addition of two values", tags="Single arithmetics")
	@GetMapping("/add")
	public String add(String nr1, String nr2) {
		return myCalcService.Addition(nr1, nr2);
	}
	
	//multiplication of two values
	@Operation(summary = "Multiplication GET request", description = "Multiplication of two values", tags="Single arithmetics")
	@GetMapping("/mult")
	public String mult(String nr1, String nr2) {		 
		return myCalcService.Multiplication(nr1, nr2);
	}
	
	//user can select sub add or mult and any number of input variables
	@Operation(summary = "Select arithmetics GET request", description = "Choose arithmetic in URL", tags="Multiple arithmetics")
	@GetMapping(value="/multVal/{type}/{values}")
	public String multVal(@PathVariable String type, @PathVariable String[] values){	 
		return myCalcService.MultVal(type, values);
	}
	
	@Hidden
	@RequestMapping(
			value = "/error",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_HTML_VALUE)
	public String error() {
		return "Wrong path" + "<br>" + start();
	}

}
