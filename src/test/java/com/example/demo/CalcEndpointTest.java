package com.example.demo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalcEndpointTest {

	private String sut;

	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}

	@Test
	public void testHejNameService() throws IOException {
		String baseText = "hej";
		String baseTextWithSpace = baseText + " ";

		String testData = "Maria";
		String expected = baseTextWithSpace + testData;
		String notExpected = expected + " not match";

		String url = sut + "/name";
		String params = "?name=" + testData;
		String query = url + params;
		String actual = HttpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
		assertNotEquals(actual, baseText);
		assertNotEquals(actual, baseTextWithSpace);
		assertNotEquals(actual, notExpected);
	}

}
