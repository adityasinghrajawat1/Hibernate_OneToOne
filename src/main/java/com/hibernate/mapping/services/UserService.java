package com.hibernate.mapping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.mapping.model.User;
import com.hibernate.mapping.model.UserProfile;
import com.hibernate.mapping.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	public Optional<User> getById(Long id)
	{
		return userRepository.findById(id);
	}
	
	public  boolean removeUser(Long id)
	{
		if(userRepository.findById(id).isPresent())
		{
			userRepository.deleteById(id);
			return true;
		}
		
		throw new IllegalArgumentException("No User found with id "+id);
	}
	
	public String getAddressById(Long id)
	{
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent() && user.get().getUserProfile() != null)
		{
			return user.get().getUserProfile().getAddress();
		}
		
		return "Address Not Found";
	}
}
