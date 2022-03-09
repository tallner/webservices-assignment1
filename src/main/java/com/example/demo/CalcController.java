package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.SpringVersion;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CalcController {
	
	//substraction operation of two values
	@GetMapping("/sub")
	public String substraction(int nr1, int nr2) throws myException {
		
		System.out.println("ok");
		return "Result: " + Integer.toString(nr1-nr2);
        
//		try {
//			return "Result: " + Integer.toString(result);
 //       } catch (ActorNotFoundException ex) {
 //           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", ex);
    //    }
	}
	
	//addition operation of two values
	@GetMapping("/add")
	public String addition(int nr1, int nr2) {
		int result = nr1+nr2;
		return "Result: " + Integer.toString(result);
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
