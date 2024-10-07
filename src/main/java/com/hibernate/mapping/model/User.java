package com.hibernate.mapping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profile_id", referencedColumnName="id")
	private UserProfile userProfile;

	
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}
	
	

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	
	
	public UserProfile getUserProfile() 
	{
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) 
	{
		this.userProfile = userProfile;
	}
	
}
