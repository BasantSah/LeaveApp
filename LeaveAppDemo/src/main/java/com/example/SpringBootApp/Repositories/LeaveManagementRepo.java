package com.example.SpringBootApp.Repositories;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.SpringBootApp.Constant.LeaveConstant;

//This is repository class to intract with DB but as of we use collection to maintain it
@Repository
public class LeaveManagementRepo {
	
	static Map<String, Object> leaveDetails = new HashMap<String, Object>();
	
	static 
	{
		leaveDetails.put(LeaveConstant.CL, 7);
		leaveDetails.put(LeaveConstant.SL, 7);
		leaveDetails.put(LeaveConstant.EL, 22);
		leaveDetails.put(LeaveConstant.ML, 180);
	}
	
	public void updateLeave(String leaveType,Integer leaveNo)
	{
		leaveDetails.put(leaveType, (Integer)leaveDetails.get(leaveType)-leaveNo);
		leaveDetails.put(LeaveConstant.EC,"Leave Applied Successfully");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

		
		Date date = new Date();  
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
		Date yearEndDate = cal.getTime();
		if(date.compareTo(yearEndDate)==0)
		{
			System.out.println("yearEndDate "+formatter.format(yearEndDate));
			leaveDetails.put(LeaveConstant.CL, 7);
			leaveDetails.put(LeaveConstant.SL, 7);
			leaveDetails.put(LeaveConstant.EL, 22);
			leaveDetails.put(LeaveConstant.ML, 180);
			leaveDetails.put(LeaveConstant.EC,"All Leave updated and previous leave elapsed");
		}
		else
		{
			System.out.println("current date "+formatter.format(date));
		}
		
		
	}
	public void updateError(String errorMsg)
	{
		
		
		leaveDetails.put(LeaveConstant.EC,errorMsg);
	}

	public Map<String, Object> getLeaveDetails() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

		
		Date date = new Date();  
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
		Date yearEndDate = cal.getTime();
		if(date.compareTo(yearEndDate)==0)
		{
			System.out.println("yearEndDate "+formatter.format(yearEndDate));
			leaveDetails.put(LeaveConstant.CL, 7);
			leaveDetails.put(LeaveConstant.SL, 7);
			leaveDetails.put(LeaveConstant.EL, 22);
			leaveDetails.put(LeaveConstant.ML, 180);
			leaveDetails.put(LeaveConstant.EC,"All Leave updated and previous leave elapsed");
		}
		else
		{
			System.out.println("current date "+formatter.format(date));
		}
		return leaveDetails;
	}
	

}
