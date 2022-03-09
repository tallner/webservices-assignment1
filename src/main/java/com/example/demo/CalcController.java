package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class CalcController {
	
	//substraction operation of two values
	@GetMapping("/sub")
	public String substraction(String nr1, String nr2) {
		 try{
			 System.out.println("nr1: " + Integer.valueOf(nr1) + "nr2: " + Integer.valueOf(nr2));
				
		    return ("Result: " + Integer.valueOf(nr1));
		 }
		catch(NumberFormatException e ){
		  return ("Check your inputs");
		 }
	}
	
	//addition operation of two values
	@GetMapping("/add")
	public String addition(int nr1, int nr2) {
		
		try{
			int result = nr1+nr2;
			return "Result: " + Integer.toString(result);
		 }
		catch(HttpClientErrorException e ){
			return ("Check your inputs");
		 }
	}
	
	//multiplication of two values
	@GetMapping("/mult")
	public String multiplication(int nr1, int nr2) {
		int result = nr1*nr2;
		return "Result: " + Integer.toString(result);
	}
	
	//user can select sub add or mult and any number of input variables
	@GetMapping(value="/multVal/{type}/{values}")
	public int test(@PathVariable int[] values, @PathVariable String type)
	{
		int result = values[0];
				
		
		for (int i=1; i<values.length;i++) {
			
			switch (type) {
				case "sub": result = result - values[i];
					break;
				case "add": result = result + values[i];
					break;
				case "mult": result = result * values[i];
					break;

			default: result = 0;
				break;
			}	
		}
		
		System.out.println(result);
		
	    return result; 
	}

}
