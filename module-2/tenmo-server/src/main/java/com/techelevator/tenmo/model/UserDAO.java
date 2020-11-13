package com.techelevator.tenmo.model;

import java.util.List;

public interface UserDAO {
	
	public List<User> getAllUsers();
	
	public User getUserById(Long id);
	
	public User getUserByUsername(String username);
}
