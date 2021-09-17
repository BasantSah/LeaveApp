package com.example.SpringBootApp.Service;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBootApp.Constant.LeaveConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class LeaveManagementServiceTest {
	
	/*
	 * @Autowired LeaveManagementService leaveManagementService;
	 * 
	 */
	@LocalServerPort
    int randomServerPort;
	
	@Test()
	public void testHelloWorld() {
		try {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/getHelloWorld";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
	  //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	    
		}
		catch(Exception e)
		{
			System.out.println("Exception occur in testHelloWorld "+e);
		}
	}
	
	@Test()
	public void testGetLeaveDetails() {

		RestTemplate restTemplate = new RestTemplate();
		// fail("Not yet implemented");
		try {

			final String baseUrl = "http://localhost:" + randomServerPort + "/getLeaveDetails";
			URI uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			// Verify request succeed
			System.out.println("GetLeave Test " + result.getStatusCode() + " ResCodeValue " + result.getStatusCodeValue());
			assertEquals(200, result.getStatusCodeValue());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test()
	public void testApplyLeave() {

		RestTemplate restTemplate = new RestTemplate();
		// fail("Not yet implemented");
		try {

			final String baseUrl = "http://localhost:" + randomServerPort + "/applyLeave";
			URI uri = new URI(baseUrl);
			
			
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			// Verify request succeed
			System.out.println("Apply Test " + result.getStatusCode() + " ResCodeValue " + result.getStatusCodeValue());
			assertEquals(200, result.getStatusCodeValue());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
