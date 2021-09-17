package com.example.SpringBootApp.Controller;
//controller to receive request

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootApp.Service.LeaveManagementService;

@RestController
public class LeaveManagementController {
	@Autowired
	LeaveManagementService leaveManagementService;

	Logger logger = Logger.getLogger(LeaveManagementController.class.getName());

	@GetMapping("getHelloWorld")
	public ResponseEntity<Object> helloWorld() {
		logger.info("getHelloWorld Called");
		return new ResponseEntity<>("Hello Pojo", HttpStatus.OK);
	}

	@GetMapping("getLeaveDetails")
	public ResponseEntity<Object> getLeaveDetails() {

		logger.info("getLeaveDetails Called ");
		return new ResponseEntity<>(leaveManagementService.getLeaveDetails(), HttpStatus.OK);
	}

	@PostMapping("applyLeave")
	ResponseEntity<Object> applyLeave(@RequestParam("leaveType") String leaveType,
			@RequestParam("stratDate") String stratDate, @RequestParam("endDate") String endDate) {

		logger.info("applyLeave Called with stratDate " + stratDate);
		leaveManagementService.applyLeave(leaveType, stratDate, endDate);
		return new ResponseEntity<>(leaveManagementService.getLeaveDetails(), HttpStatus.OK);

	}

}
