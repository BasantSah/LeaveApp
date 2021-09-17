package com.example.SpringBootApp.Controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBootApp.Repositories.LeaveManagementRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LeaveManagementControllerTest {

	@LocalServerPort
	int randomServerPort;

	Logger logger = Logger.getLogger(LeaveManagementRepo.class.getName());

	@Test()
	public void testHelloWorld() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "http://localhost:" + randomServerPort + "/getHelloWorld";
			URI uri = new URI(baseUrl);
			ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
			// Verify request succeed
			assertEquals(200, result.getStatusCodeValue());

		} catch (Exception e) {

			logger.info("Exception occur in testHelloWorld " + e);
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

			logger.info("GetLeave Test " + result.getStatusCode() + " ResCodeValue " + result.getStatusCodeValue());
			assertEquals(200, result.getStatusCodeValue());

		} catch (Exception e) {

			logger.info("Exception occur in testGetLeaveDetails " + e);
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

			logger.info("Apply Test " + result.getStatusCode() + " ResCodeValue " + result.getStatusCodeValue());
			assertEquals(200, result.getStatusCodeValue());

		} catch (Exception e) {
			logger.info("Exception occur in testApplyLeave " + e);
		}
	}

}
