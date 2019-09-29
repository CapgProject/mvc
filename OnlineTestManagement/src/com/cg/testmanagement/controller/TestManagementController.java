package com.cg.testmanagement.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.testmanagement.dto.OnlineTest;
import com.cg.testmanagement.dto.Question;
import com.cg.testmanagement.dto.User;
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
	public String showAddTest() {	
	return "AddTest";
	}
	@RequestMapping(value = "/addtestsubmit", method = RequestMethod.POST)
	public String addTest(@RequestParam("testName") String name, @RequestParam("testDuration") @DateTimeFormat(pattern="HH:mm:ss") LocalTime duration, @RequestParam(name="startTime") @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") LocalDateTime startTime, @RequestParam("endTime") @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") LocalDateTime endTime, @RequestParam("marksScored") double marksScored) {
		try {
			OnlineTest test = new OnlineTest();
			test.setTestName(name);
			test.setTestTotalMarks(new Double(0));
			test.setTestDuration(duration);
			test.setStartTime(startTime);
			test.setEndTime(endTime);
			test.setTestMarksScored(marksScored);
			test.setIsdeleted(false);
			testservice.addTest(test);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	@RequestMapping(value="/addQuestion", method=RequestMethod.GET)
	public String showAddQuestion(@ModelAttribute("question") Question question) {
		return "AddQuestion";
	}
	@RequestMapping(value="/addquestionsubmit", method=RequestMethod.POST)
	public String addQuestion(@ModelAttribute("question") Question question, @RequestParam("testid") long id) {
		try {
			question.setChosenAnswer(0);
			question.setIsDeleted(false);
			question.setMarksScored(new Double(0));
			testservice.addQuestion(id, question);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public String showAddUser(@ModelAttribute("user") User user) {
		return "AddUser";
	}
	@RequestMapping(value="/addusersubmit", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		try {
			user.setUserTest(null);
			user.setIsAdmin(false);
			user.setIsDeleted(false);
			testservice.registerUser(user);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	@RequestMapping(value="/showalltests", method=RequestMethod.GET)
	public ModelAndView showTest() {
		List<OnlineTest> testList = testservice.getTests();
		return new ModelAndView("ShowTest", "testdata", testList);
	}
	@RequestMapping(value="/showallusers", method=RequestMethod.GET)
	public ModelAndView showUser() {
		List<User> userList = testservice.getUsers();
		return new ModelAndView("ShowUser", "userdata", userList);
	}
	@RequestMapping(value="/removetest", method=RequestMethod.GET)
	public String showRemoveTest() {
		return "RemoveTest";
	}
	@RequestMapping(value="removetestsubmit", method=RequestMethod.POST)
	public String removeTest(@RequestParam("testid") long id) {
		try {
			OnlineTest deleteTest = testservice.searchTest(id);
			testservice.deleteTest(deleteTest.getTestId());
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	@RequestMapping(value="/removequestion", method=RequestMethod.GET)
	public String showRemoveQuestion() {
		return "RemoveQuestion";
	}
	@RequestMapping(value="removequestionsubmit", method=RequestMethod.POST)
	public String removeQuestion(@RequestParam("questionid") long id) {
		try {
			Question question = testservice.searchQuestion(id);
			testservice.deleteQuestion(question.getOnlinetest().getTestId(), question.getQuestionId());
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	@RequestMapping(value="/givetest", method=RequestMethod.GET)
	public String showQuestion() {
		return "GiveTest";
	}
	@RequestMapping(value="assigntest", method=RequestMethod.GET)
	public String showAssignTest() {
		return "AssignTest";
	}
	@RequestMapping(value="assigntestsubmit", method=RequestMethod.POST)
	public String assignTest(@RequestParam("testid") long testId, @RequestParam("userid") long userId) {
		try {
			testservice.assignTest(userId, testId);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	@RequestMapping(value="/getresult", method=RequestMethod.GET)
	public String showGetResult() {
		return "GetResult";
	}
	@RequestMapping(value="/getresultsubmit", method=RequestMethod.POST)
	public ModelAndView getResult(@RequestParam("testid") long id) {
		try {
			OnlineTest test = testservice.searchTest(id);
			double marks = testservice.getResult(test);
			return new ModelAndView("ShowResult", "result", marks);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView("home");		
	}
	@RequestMapping(value="/updatetest", method=RequestMethod.GET)
	public String showUpdateTest() {
		return "UpdateTest";
	}
	@RequestMapping(value="/updatetestinput", method=RequestMethod.POST)
	public ModelAndView updateTest(@RequestParam("testid") long id) {
		OnlineTest test;
		try {
			test = testservice.searchTest(id);
			return new ModelAndView("UpdateTest", "Update", test);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView("home");
	}
	@RequestMapping(value="/updatetestsubmit", method=RequestMethod.POST)
	public String actualUpdate(@RequestParam("testId") long id, @RequestParam("testName") String name, @RequestParam("testDuration") @DateTimeFormat(pattern="HH:mm:ss") LocalTime duration, @RequestParam(name="startTime") @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") LocalDateTime startTime, @RequestParam("endTime") @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") LocalDateTime endTime) {
		OnlineTest test = new OnlineTest();
		test.setTestName(name);
		test.setTestDuration(duration);
		test.setStartTime(startTime);
		test.setEndTime(endTime);
		try {
			testservice.updateTest(id, test);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
}
