package com.techelevator.tenmo.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCUserDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		while(results.next()) {
			User user = mapRowToUser(results);
			users.add(user);
		}
		return users;
	}
	
	@Override
	public User getUserById(Long id) {
		String query = "SELECT * FROM users WHERE user_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, id);
		if(results.next()) {
			return mapRowToUser(results);
		}
		System.out.println("No user exists with the ID of " + id);
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		String query = "SELECT * FROM users WHERE username = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, username);
		if(results.next()) {
			return mapRowToUser(results);
		}
		System.out.println("No user exists by the name of " + username);
		return null;
	}

	private User mapRowToUser(SqlRowSet results) {
		User user = new User();
		user.setId(results.getLong("user_id"));
		user.setUsername(results.getString("username"));
		user.setPassword(results.getString("password_hash"));
		return user;
	}
}
