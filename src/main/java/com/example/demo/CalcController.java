package com.example.demo;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalcController implements ErrorController {
	
	private CalcService myCalcService = new CalcService();
	
	//start page
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
	@GetMapping("/sub")
	public String sub(String nr1, String nr2) {
		String result = "";
		
		try{			
			 result = myCalcService.Substraction(nr1, nr2);
		 }
		catch(NumberFormatException e ){
			result = ("Check your inputs");
		 }
		 return result;
	}
	
	//addition operation of two values
	@GetMapping("/add")
	public String add(String nr1, String nr2) {
		String result = "";

		try{			
			 result = myCalcService.Addition(nr1, nr2);
		 }
		catch(NumberFormatException e ){
			result = ("Check your inputs");
		 }
		 
		return result;
	}
	
	//multiplication of two values
	@GetMapping("/mult")
	public String mult(String nr1, String nr2) {
		String result = "";
		
		try{			
			 result = myCalcService.Multiplication(nr1, nr2);
		 }
		catch(NumberFormatException e ){
			result = ("Check your inputs");
		 }
		 
		return result;
	}
	
	//user can select sub add or mult and any number of input variables
	@GetMapping(value="/multVal/{type}/{values}")
	public String multVal(@PathVariable String type, @PathVariable String[] values){
		String result = "";
		
		try{			
			 result = myCalcService.MultVal(type, values);
		 }
		catch(NumberFormatException e ){
			result = ("Check your inputs");
		 }
		 
		return result;
	}
	
	
	
	
	@RequestMapping(
			value = "/error",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_HTML_VALUE)
	public String error() {
		return "Wrong path" + "<br>" + start();
	}

}
