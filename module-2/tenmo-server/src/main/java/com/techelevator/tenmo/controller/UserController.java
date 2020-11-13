package com.techelevator.tenmo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.techelevator.tenmo.model.JDBCUserDAO;
import com.techelevator.tenmo.model.User;

@RestController
//@RequestMapping(value = "users")
public class UserController {
	
private JDBCUserDAO userDao;
	
	public UserController(JDBCUserDAO dao) {
		this.userDao = dao;
	}
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		logAPICall("Getting all users");
		List<User> users = userDao.getAllUsers();
		return users;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) {
		logAPICall("Getting users by id of: " + id);
		User user = userDao.getUserById(id);
		user.setPassword(null);
		return user;
	}
	
	private void logAPICall(String message) {
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
	    String timeNow = now.format(formatter);
	    System.out.println(timeNow + ": " + message);
	}	
}
