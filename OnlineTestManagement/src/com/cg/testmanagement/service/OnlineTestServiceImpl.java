package com.cg.testmanagement.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.cg.testmanagement.dto.OnlineTest;
import com.cg.testmanagement.dto.Question;
import com.cg.testmanagement.dto.User;
import com.cg.testmanagement.exception.UserException;

public class OnlineTestServiceImpl implements OnlineTestService{

	@Override
	public OnlineTest addTest(OnlineTest onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnlineTest updateTest(Long testId, OnlineTest onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnlineTest deleteTest(Long testId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question addQuestion(Long testId, Question question) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question updateQuestion(Long testId, Long questionId, Question question) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question deleteQuestion(Long testId, Long questionId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean answerQuestion(OnlineTest onlineTest, Question question, Integer chosenAnswer) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question showQuestion(OnlineTest onlineTest, Long questionId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean assignTest(Long userId, Long testId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getResult(OnlineTest onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateTotalMarks(OnlineTest onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnlineTest searchTest(Long testId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchUser(Long userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OnlineTest> getTests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateUserId(Long id) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateTestId(Long id) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateQuestionId(Long id) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUserName(String name) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validatePassword(String password) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateDate(LocalDateTime startDate, LocalDateTime endDate) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateTestDuration(LocalTime duration, LocalDateTime startDate, LocalDateTime endDate)
			throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateEndTime(LocalDateTime endDate) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void questionAnswerValidate(Integer questionAnswer) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateProfile(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
