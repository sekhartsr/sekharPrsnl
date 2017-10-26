package com.equinix.workvisit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.equinix.workvisit.model.WorkVisit;

/**
 * @author Sekhar
 *
 */
@Controller
public class WorkVisitController {
	
	@Autowired
	private WorkVisitRestController workVisitRestController;
	
	@RequestMapping(value="/main",method = RequestMethod.GET)
    public String mainPage(){
        return "main";
    }
	
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
//        return "home";
        return "main";
    }
	
	@RequestMapping(value="/viewDetails/{firstName}",method = RequestMethod.GET)
    public String viewUserDetails(@PathVariable String lastName, Model model){
		WorkVisit workVisit = workVisitRestController.getWorkVisit(lastName);
		model.addAttribute("workVisit", workVisit);
        return "viewUser";
    }

}
