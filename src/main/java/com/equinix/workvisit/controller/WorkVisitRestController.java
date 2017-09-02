package com.equinix.workvisit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equinix.workvisit.model.WorkVisit;
import com.equinix.workvisit.model.WorkVisitIBXInfo;
import com.equinix.workvisit.model.WorkVisitUsers;
import com.equinix.workvisit.services.WorkVisitIBXInfoService;
import com.equinix.workvisit.services.WorkVisitUsersService;

@RestController
public class WorkVisitRestController {
	
	@Autowired
	WorkVisitIBXInfoService workVisitIBXInfoService;
	
	@Autowired
	WorkVisitUsersService workVisitUsersService;

	WorkVisit workVisit = new WorkVisit();

	List<WorkVisitUsers> workVisitUsers = new ArrayList<WorkVisitUsers>();

	@RequestMapping(value = "/getallUsers", method = RequestMethod.GET)
	public List<WorkVisitUsers> getAllUsers() {
		List<WorkVisitUsers> workVisitUsers =  workVisitUsersService.findAll();
		return workVisitUsers;
	}

	@RequestMapping(value = "/getworkvisit", method = RequestMethod.GET)
	public WorkVisit getWorkVisit() {
		return workVisit;
	}
	
	@RequestMapping(value = "/getIBXInfo", method = RequestMethod.GET)
	public List<WorkVisitIBXInfo> getWorkVisitIBXInfo() {
		return workVisitIBXInfoService.findAll();
	}

	@RequestMapping(value = "/postworkvisit", method = RequestMethod.POST)
	public void postWorkVisit(@RequestBody WorkVisit wrkVisit) {

		return;
	}
}
