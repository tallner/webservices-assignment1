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
public class hejController {
	
	//testa stringbuilder
	
	//Default är GET när man använder @RequestMapping
	@RequestMapping("/")
	public String hej() {
		return "hej elever";
	}
	
	//Annars måste den definieras
	@RequestMapping(method = RequestMethod.GET, path="/img", produces = MediaType.IMAGE_JPEG_VALUE)
	public void img(HttpServletResponse response) throws IOException {
		System.out.println("nu kör vi!");
		
		var imgFile = new ClassPathResource("598.jpg");
		System.out.println(imgFile.getPath());
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}
	
	@GetMapping("/vem")
	public String hejVem(String Who) {
		return "hej " + Who + ", vem är du?";
	}
	
	@GetMapping("/sub")
	public String substraction(int nr1, int nr2) throws myException {
		System.out.println(SpringVersion.getVersion());
		//int result = nr1-nr2;
		
		System.out.println("ok");
		return "Result: " + Integer.toString(nr1-nr2);
        
//		try {
//			return "Result: " + Integer.toString(result);
 //       } catch (ActorNotFoundException ex) {
 //           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", ex);
    //    }
	}
	
	@GetMapping("/add")
	public String addition(int nr1, int nr2) {
		int result = nr1+nr2;
		return "Result: " + Integer.toString(result);
	}
	
	@GetMapping("/mult")
	public String multiplication(int nr1, int nr2) {
		int result = nr1*nr2;
		return "Result: " + Integer.toString(result);
	}
	
	
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
