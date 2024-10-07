package com.hibernate.mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.mapping.model.User;
import com.hibernate.mapping.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("start")
	public String getStarted()
	{
		return "Starting.............";
	}
	
	@PostMapping("save")
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@GetMapping("getAll")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("getById/{id}")
	public Optional<User> getById(@PathVariable Long id)
	{
		return userService.getById(id);
	}
	
	@DeleteMapping("remove/{id}")
	public String removeUser(@PathVariable Long id)
	{
		userService.removeUser(id);
		return "User deleted with id: "+id;
	}
	
	@GetMapping("getAddressById/{id}")
	public String getAddressById(@PathVariable Long id)
	{
		return userService.getAddressById(id);
	}
}
