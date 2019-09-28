package com.cg.testmanagement.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.testmanagement.dto.OnlineTest;
import com.cg.testmanagement.exception.UserException;
import com.cg.testmanagement.service.OnlineTestService;

@Controller
public class TestManagementController {

	@Autowired
	OnlineTestService testservice;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String displayHomePage() {
		return "home";
	}
	@RequestMapping(value = "/addtest", method = RequestMethod.GET)
	public String showAddTest(@ModelAttribute("test") OnlineTest test) {
		return "AddTest";
	}
	@RequestMapping(value = "/addtestsubmit", method = RequestMethod.POST)
	public String addTest(@ModelAttribute("test") OnlineTest test) {
		try {
			DateTimeFormatter durarationFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String timeString = test.getTestDuration().format(durarationFormatter);
			LocalTime duration = LocalTime.parse(timeString, durarationFormatter);
			test.setTestDuration(duration);
			testservice.addTest(test);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
}
