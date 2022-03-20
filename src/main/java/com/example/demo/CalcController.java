package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalcController {
	
	// add tests for all endpoints and the controller
	// either abstract all calculations to separate classes and test each or 
	// keep them in controller and test the controller class only
	
	private CalcService myCalcService = new CalcService();
	
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

}
