package com.abhi.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.abhi.bean.User;

@Component
public class UserDAO {
	
	private static List<User> users = new ArrayList<>();
	private int userCount = 3;
	static {
		users.add(new User(1, "abhishek", new Date(21-10-1988)));
		users.add(new User(2, "Sneha", new Date(29-04-1992)));
		users.add(new User(3, "Divya", new Date(28-05-1985)));
	} 
	
	public List<User> findAll() {
		return users;
	}
	
	public User save (User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
	}
		return null;
}}
