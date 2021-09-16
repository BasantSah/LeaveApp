package com.example.SpringBootApp.Controller;
//controller to receive request

import java.util.Map;

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
	
	@GetMapping("getHelloWorld")
	public ResponseEntity <Object>  helloWorld()
	{
		System.out.println("LeaveManagementController called");
		return new ResponseEntity<>("Hello Pojo", HttpStatus.OK);
	}
	
	@GetMapping("getLeaveDetails")
	public ResponseEntity <Object> getLeaveDetails() {
		System.out.println("getLeaveDetails called");
		//return leaveManagementService.getLeaveDetails();
		return new ResponseEntity<>(leaveManagementService.getLeaveDetails(), HttpStatus.OK);
	}
	
	@PostMapping("applyLeave")
	ResponseEntity<Object> applyLeave(@RequestParam("leaveType") String leaveType,
			@RequestParam("stratDate") String stratDate, @RequestParam("endDate") String endDate) {
		System.out.println("applyLeave called");
		System.out.println("leaveType " + leaveType + " endDate " + endDate+ " stratDate " + stratDate);
		leaveManagementService.applyLeave(leaveType, stratDate,endDate);
		return new ResponseEntity<>(leaveManagementService.getLeaveDetails(), HttpStatus.OK);
		// return ResponseEntity.ok("Leave Applied Successfully!");
	}
	
	
	
	
	

}
