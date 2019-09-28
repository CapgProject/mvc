package com.cg.testmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.testmanagement.service.OnlineTestService;

@Controller
public class TestManagementController {

	@Autowired
	OnlineTestService testservice;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String displayHomePage() {
		return "home";
	}
}
