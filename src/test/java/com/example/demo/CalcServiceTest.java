package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CalcServiceTest {
	
	private CalcService sut1;
	//private CalcController sut2;

	@Before //körs innan test
	public void setUp() {
		sut1 = new CalcService(); //klassen som testas initieras innan test börjar
		//sut2 = new CalcController();
	}

	@Test
	public void testSubSucc() {
		String actual = sut1.Substraction("5", "4");
		String expected = "Result: 1";
		assertEquals(expected, actual);
		
		//String actual2 =  sut2.substraction("7", "6");
		//assertEquals(expected, actual2);

		//assertTrue(actual == expected);

	}
	
	@Test
	public void testSubFail() {
		String actual = sut1.Substraction("5","6");
		String expected = "56";
		//assertTrue(actual == expected);
		
		assertEquals(expected, actual);
	}

}
