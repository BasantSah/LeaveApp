package com.example.SpringBootApp.Service;
//service layer
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootApp.Repositories.LeaveManagementRepo;

@Service
public class LeaveManagementService {

	@Autowired
	LeaveManagementRepo leaveManagementRepo ;
	
	public Map<String, Object> getLeaveDetails() {
		//leaveManagementRepo.inItLeave();
		return leaveManagementRepo.getLeaveDetails();
	}
	
	public void applyLeave(String leaveType,String stratDate,String endDate){
		Integer ln;
		int leaveNo=0;
		//leaveManagementRepo.inItLeave();
		System.out.println("stratDate in service "+stratDate+" endDate "+endDate);
		Map<String, Object> leaveDetails = leaveManagementRepo.getLeaveDetails();
		System.out.println("leaveDetails in service before change"+leaveDetails);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try
		{
			Date d1 = sdf.parse(stratDate);
            Date d2 = sdf.parse(endDate);
            System.out.println("d1 in try "+d1+" d2 "+d2);
			long difference_In_Time = d2.getTime() - d1.getTime();

            
            leaveNo = (int)((difference_In_Time / (1000 * 60 * 60 * 24)) % 365)+1;
            System.out.println("leaveNo cal in try "+leaveNo);
		}
		catch(Exception e)
		{
			
		}
		ln=(Integer)leaveDetails.get(leaveType);
		
		
		if(leaveNo<=ln && leaveNo!=0)
		{
			leaveManagementRepo.updateLeave(leaveType,leaveNo);
		}
		else
		{
			leaveManagementRepo.updateError("This Leave is not enough select other leave");
		}
		System.out.println("leaveDetails in service after change "+leaveDetails);
		System.out.println("ln in service "+ln);
		System.out.println("leaveNo cal outside try "+leaveNo);
	}
}
