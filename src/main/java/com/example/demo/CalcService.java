package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;

public class CalcService {
	
	private String nr1;
	private String nr2;
	
	public CalcService() {
	}
	
	public String Substraction(String nr1, String nr2) {
		return "Result: " + (Integer.valueOf(nr1)-Integer.valueOf(nr2));
	}
	
	public String Addition(String nr1, String nr2) {
		return "Result: " + (Integer.valueOf(nr1)+Integer.valueOf(nr2));
	}
	
	public String Multiplication(String nr1, String nr2) {
		return "Result: " + (Integer.valueOf(nr1)*Integer.valueOf(nr2));
	}
	
	public String MultVal(String type, String[] values) {
		int result = Integer.valueOf(values[0]); //add the first value, otherwise the mult will be 0
			
		for (int i=1; i<values.length;i++) {
			
			switch (type) {
				case "sub": 
					result -= Integer.valueOf(values[i]);
					break;
				case "add": 
					result += Integer.valueOf(values[i]);
					break;
				case "mult": 
					result *= Integer.valueOf(values[i]);
					break;

			default: 
				return ("Check your type input");
			}	
		}
	
		return "Result: " + Integer.toString(result); 
	}

}
