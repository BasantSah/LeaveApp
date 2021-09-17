package com.example.SpringBootApp.Service;

//service layer
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootApp.Repositories.LeaveManagementRepo;

@Service
public class LeaveManagementService {

	@Autowired
	LeaveManagementRepo leaveManagementRepo;
	Logger logger = Logger.getLogger(LeaveManagementService.class.getName());

	public Map<String, Object> getLeaveDetails() {

		return leaveManagementRepo.getLeaveDetails();
	}

	public void applyLeave(String leaveType, String stratDate, String endDate) {
		Integer ln;
		int leaveNo = 0;

		logger.info("stratDate in service " + stratDate + " endDate " + endDate);

		Map<String, Object> leaveDetails = leaveManagementRepo.getLeaveDetails();

		logger.info("leaveDetails in service before change" + leaveDetails);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date d1 = sdf.parse(stratDate);
			Date d2 = sdf.parse(endDate);

			long difference_In_Time = d2.getTime() - d1.getTime();

			leaveNo = (int) ((difference_In_Time / (1000 * 60 * 60 * 24)) % 365) + 1;

			logger.info("leaveNo cal in try " + leaveNo);
		} catch (Exception e) {
			logger.info("Exception occur while applying Leave " + e);
		}
		ln = (Integer) leaveDetails.get(leaveType);

		if (leaveNo <= ln && leaveNo != 0) {
			leaveManagementRepo.updateLeave(leaveType, leaveNo);
		} else {
			leaveManagementRepo.updateError("This Leave is not enough select other leave");
		}

		logger.info("leaveDetails in service after change " + leaveDetails);

	}
}
