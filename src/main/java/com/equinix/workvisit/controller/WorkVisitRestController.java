package com.equinix.workvisit.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.equinix.workvisit.model.WorkVisit;
import com.equinix.workvisit.model.WorkVisitIBXInfo;
import com.equinix.workvisit.model.WorkVisitUsers;
import com.equinix.workvisit.services.WorkVisitIBXInfoService;
import com.equinix.workvisit.services.WorkVisitService;
import com.equinix.workvisit.services.WorkVisitUsersService;

/**
 * @author Sekhar
 *
 */
@RestController
public class WorkVisitRestController {

	@Autowired
	WorkVisitIBXInfoService workVisitIBXInfoService;

	@Autowired
	WorkVisitUsersService workVisitUsersService;

	@Autowired
	WorkVisitService workVisitService;

	List<WorkVisitUsers> workVisitUsers = new ArrayList<WorkVisitUsers>();

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<WorkVisitUsers> getAllUsers() {
		List<WorkVisitUsers> workVisitUsers = workVisitUsersService.findAll();
		return workVisitUsers;
	}

	@RequestMapping(value = "/getByIbx", method = RequestMethod.GET)
	public List<WorkVisitIBXInfo> findByIbx(@RequestParam String ibx) {
		List<WorkVisitIBXInfo> workVisitCage = workVisitIBXInfoService.findByIbx(ibx);
		return workVisitCage;
	}

	@RequestMapping(value = "/getByCage", method = RequestMethod.GET)
	public List<WorkVisitIBXInfo> findByCage(@RequestParam String cage) {
		List<WorkVisitIBXInfo> workVisitCage = workVisitIBXInfoService.findByCage(cage);
		return workVisitCage;
	}

	@RequestMapping(value = "/getworkvisit", method = RequestMethod.GET)
	public WorkVisit getWorkVisit(String workVisitUser) {
		return workVisitService.findByUserName(workVisitUser);
	}

	@RequestMapping(value = "/getIBXInfo", method = RequestMethod.GET)
	public List<WorkVisitIBXInfo> getWorkVisitIBXInfo() {
		return workVisitIBXInfoService.findAll();
	}

	@RequestMapping(value = "/postWorkVisit", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ModelAndView postWorkVisit(@RequestBody WorkVisit workVisit) {
		ModelAndView mav = new ModelAndView("index");
		try {
			if (workVisit != null) {
				for (WorkVisitUsers workVisitUser : workVisit.getWorkVisitUsers()) {
					WorkVisit wrkVisit = new WorkVisit();
					wrkVisit.setIbx(workVisit.getIbx());
					wrkVisit.setCage(workVisit.getCage());
					wrkVisit.setCabinet(workVisit.getCabinet());
					wrkVisit.setStartDate(workVisit.getStartDate());
					wrkVisit.setEndDate(workVisit.getEndDate());
					wrkVisit.setStartTime(workVisit.getStartTime());
					wrkVisit.setEndTime(workVisit.getEndTime());
					wrkVisit.setCreateDt(getSQLTimestamp());
					wrkVisit.setWorkVisitUser(workVisitUser.getUserName());
					workVisitService.save(wrkVisit);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("workVisit", workVisit);
		return mav;
	}

	protected Timestamp getSQLTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}
}
