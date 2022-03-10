package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class CalcController {
	
	//made a few different error handlings just to try
	
	//substraction operation of two values --> NumberFormatException
	@GetMapping("/sub")
	public String substraction(String nr1, String nr2) {
		String result = "";
		try{			
			 result = ("Result: " + (Integer.valueOf(nr1)-Integer.valueOf(nr2)));
		 }
		catch(NumberFormatException e ){
			result = ("Check your inputs");
		 }
		 
		 return result;
	}
	
	//addition operation of two values --> HttpClientErrorException does not work in this case!
	@GetMapping("/add")
	public String addition(int nr1, int nr2) {
		String result = "";
		try{
			result = "Result: " + Integer.toString(nr1+nr2);
		 }
		catch(HttpClientErrorException e ){
			result = ("Check your inputs");
		 }
		
		return result;
	}
	
	//multiplication of two values --> just check if strings are values or not
	@GetMapping("/mult")
	public String multiplication(String nr1, String nr2) {
		
		String result = "";
		
		if (nr1.matches("[0-9]+") & nr2.matches("[0-9]+")) {
			result = ("Result: " + (Integer.valueOf(nr1)*Integer.valueOf(nr2)));
		}else result = "Check your inputs";
		
		return result;

	}
	
	//user can select sub add or mult and any number of input variables
	@GetMapping(value="/multVal/{type}/{values}")
	public String test(@PathVariable String[] values, @PathVariable String type)
	{
		int result = 0;
		String resultString = "";
		try{			
			result = Integer.valueOf(values[0]); //add the first value, otherwise the mult will be 0
			
			for (int i=1; i<values.length;i++) {
				
				switch (type) {
					case "sub": 
						result = result - Integer.valueOf(values[i]);
						resultString = Integer.toString(result);
						break;
					case "add": 
						result = result + Integer.valueOf(values[i]);
						resultString = Integer.toString(result);
						break;
					case "mult": 
						result = result * Integer.valueOf(values[i]);
						resultString = Integer.toString(result);
						break;

				default: resultString = ("Check your inputs");
					break;
				}	
			}
			
		 }
		catch(NumberFormatException e ){
			resultString = ("Check your inputs");
		 }
		
		
		
	    return resultString; 
	}

}
