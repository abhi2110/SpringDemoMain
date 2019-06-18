package com.abhi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abhi.DAO.UserDAO;
import com.abhi.DAO.UserNotFoundException;
import com.abhi.bean.User;

@RestController
public class UserResourceController {

	@Autowired
	private UserDAO userDAO;
	
	@GetMapping(path = "/user")
	public List<User> getAllUser() {
		return userDAO.findAll();
		
	}
	
	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable int id) {
		User user =  userDAO.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id : " +id);
		}
		return user;
		
	}
	
	@PostMapping(path = "add/user")
	public ResponseEntity User(@RequestBody User user) {
		userDAO.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(userDAO.save(user).
						getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
